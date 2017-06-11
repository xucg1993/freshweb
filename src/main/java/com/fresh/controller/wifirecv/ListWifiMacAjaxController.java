package com.fresh.controller.wifirecv;

import com.fresh.common.util.DateUtil;
import com.fresh.common.util.Json.JsonUtil;
import com.fresh.model.CommonJsonObject;
import com.fresh.model.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * MAC监测
 *
 * @author XCG
 * @since 2017/5/19.
 */
@Controller
@RequestMapping(value = "/wifimac")
public class ListWifiMacAjaxController extends BaseWifiMacController {
    /**
     * wifimac接收模块
     *
     * @throws Exception
     */
    @RequestMapping("insertWifiMac")
    public void insertWifiMac() throws Exception {
        DatagramSocket udp = new DatagramSocket(DEFAULT_PORT);
        DatagramPacket dPacket;
        byte[] echo = new byte[1];
        echo[0] = (byte) 1;
        int i = 1;
        while (true) {
            dPacket = new DatagramPacket(new byte[MAX_MSG_LEN], MAX_MSG_LEN);
            udp.receive(dPacket);
            String result = new String(dPacket.getData(), 0, dPacket.getLength());
            result = result.substring(7);
            String time = DateUtil.getTime();
            String ArrayDATA_IDS[] = result.split("\\n");
            for (int y = 0; y < ArrayDATA_IDS.length; y++) {
                String arrayDATA_id = ArrayDATA_IDS[y];
                String arrays[] = arrayDATA_id.split("\\|");
                PageData pd = new PageData();
                pd.put("FRAMEFROM", arrays[0]);
                pd.put("FRAMETO", arrays[1]);
                pd.put("FRAMEBIG", arrays[2]);
                pd.put("FRAMESMALL", arrays[3]);
                pd.put("CHANNEL", arrays[4]);
                pd.put("RSSI", arrays[5]);
                pd.put("DATE", time);
                wifiMacService.save(pd);
            }

            String[] split = result.split("\\|");
            int s = split.length - 1;
            System.out.println("====================================================");
            System.out.println("第" + i++ + "次");
            System.out.println("共" + s / 5 + "行");
            System.out.println(result + time);
            InetAddress addr = dPacket.getAddress();
            dPacket = new DatagramPacket(echo, echo.length);
            dPacket.setAddress(addr);
            udp.send(dPacket);
        }
    }

    /**
     * 日客流量
     * @param response
     * @throws Exception
     */
    @RequestMapping("getWifiMacDayList")
    public void getWifiMacDayList(HttpServletResponse response) throws Exception {
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        long curren = getStartTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Map<String,Object> map = new HashMap<>();
        List<Integer> in = new ArrayList<>();
        for (int i= 0;i<24;i++) {
            long Start = curren;
            Date st = new Date(curren);
            String StartTime = dateFormat.format(st);

            long End = curren+= 60 * 60 * 1000;
            Date da = new Date(curren);
            String EndTime = dateFormat.format(da);
            PageData pd = new PageData();
            pd.put("START",StartTime);
            pd.put("END",EndTime);
            //每小时的客流量
            int passengerflow = wifiMacService.listByDayCount(pd);
            in.add(passengerflow);
        }
        SimpleDateFormat dateFormat1 = new SimpleDateFormat(
                "yyyy-MM-dd");
        String format = dateFormat1.format(new Date());
        map.put("date",format);
        map.put("passenger",in);
        PageData pa = new PageData();
        pa.put("START",DateUtil.getDay()+" 00:00:00");
        pa.put("END",DateUtil.getDay()+" 23:59:59");
        int totals = wifiMacService.listByDayCount(pa);
        map.put("totalPassengers",totals);
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("成功");
        commonJsonObject.setData(map);
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }

    /**
     * 周客流量
     * @param response
     * @throws Exception
     */
    @RequestMapping("getWifiMacWeekList")
    public void getWifiMacWeekList(HttpServletResponse response) throws Exception {
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        Map<String,Object> map = new HashMap<>();
        List<Integer> in = new ArrayList<>();

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -6); // 日期减 如果不够减会将月变动
        Date date = calendar.getTime();
        String weekstart = sdf.format(date);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.getTime();
        Date date1 = calendar1.getTime();
        String weekend = sdf.format(date1);

        List<String> allDaysBetween = DateUtil.getAllDaysBetween(calendar, calendar1);
        for (int i= 0;i<allDaysBetween.size();i++) {
            String StartTime = allDaysBetween.get(i) + " 00:00:00";
            String EndTime = allDaysBetween.get(i) +" 23:59:59";
            PageData pd = new PageData();
            pd.put("START",StartTime);
            pd.put("END",EndTime);
            //每天的客流量
            int passengerflow = wifiMacService.listByDayCount(pd);
            in.add(passengerflow);
        }
        map.put("date",weekstart);
        map.put("passenger",in);
        map.put("weekstartandend",weekstart.substring(5)+"/"+weekend.substring(5));
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("成功");
        commonJsonObject.setData(map);
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }

    /**
     * 取本星期
     * @return
     */
    private List<String> getAndEndDate() {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        list.add(df.format(cal.getTime()));

        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//        cal.add(Calendar.WEEK_OF_YEAR, 1);
        list.add(df.format(cal.getTime()));
        return list;
    }

    /**
     * 取当天凌晨时刻
     * @return
     */
    private Long getStartTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }

    /**
     * 每日进店人数
     * @param response
     * @throws Exception
     */
    @RequestMapping("getWifiMacDayGetIntoList")
    public void getWifiMacDayGetIntoList(HttpServletResponse response) throws Exception {
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        long curren = getStartTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Map<String,Object> map = new HashMap<>();
        List<Integer> in = new ArrayList<>();
        for (int i= 0;i<24;i++) {
            long Start = curren;
            Date st = new Date(curren);
            String StartTime = dateFormat.format(st);

            long End = curren+= 60 * 60 * 1000;
            Date da = new Date(curren);
            String EndTime = dateFormat.format(da);
            PageData pd = new PageData();
            pd.put("START",StartTime);
            pd.put("END",EndTime);
            pd.put("RSSI",ENTER_NUM);
            //每小时的进店人数
            int passengerflow = wifiMacService.listByDayEnterCount(pd);
            in.add(passengerflow);
        }
        SimpleDateFormat dateFormat1 = new SimpleDateFormat(
                "yyyy-MM-dd");
        String format = dateFormat1.format(new Date());
        map.put("date",format);
        map.put("passenger",in);
        PageData pa = new PageData();
        pa.put("START",DateUtil.getDay()+" 00:00:00");
        pa.put("END",DateUtil.getDay()+" 23:59:59");
        pa.put("RSSI",ENTER_NUM);
        int totals = wifiMacService.listByDayEnterCount(pa);
        map.put("totalPassengers",totals);
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("成功");
        commonJsonObject.setData(map);
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }

    /**
     * 周进店人数
     * @param response
     * @throws Exception
     */
    @RequestMapping("getWifiMacWeekGetIntoList")
    public void getWifiMacWeekGetIntoList(HttpServletResponse response) throws Exception {
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        Map<String,Object> map = new HashMap<>();
        List<Integer> in = new ArrayList<>();

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -6); // 日期减 如果不够减会将月变动
        Date date = calendar.getTime();
        String weekstart = sdf.format(date);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.getTime();
        Date date1 = calendar1.getTime();
        String weekend = sdf.format(date1);

        List<String> allDaysBetween = DateUtil.getAllDaysBetween(calendar, calendar1);

        for (int i= 0;i<allDaysBetween.size();i++) {
            String StartTime = allDaysBetween.get(i) + " 00:00:00";
            String EndTime = allDaysBetween.get(i) +" 23:59:59";
            PageData pd = new PageData();
            pd.put("START",StartTime);
            pd.put("END",EndTime);
            pd.put("RSSI",ENTER_NUM);
            //每天的客流量
            int passengerflow = wifiMacService.listByDayEnterCount(pd);
            in.add(passengerflow);
        }
        map.put("date",weekstart);
        map.put("passenger",in);
        map.put("weekstartandend",weekstart.substring(5)+"/"+weekend.substring(5));
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("成功");
        commonJsonObject.setData(map);
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }
}
