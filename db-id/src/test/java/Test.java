import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author xianglin
 * @Date 2021/8/17 16:44
 * @Version V1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File jsonFile = new File("E:\\workspace\\test\\db-id\\src\\main\\resources\\chinese-code.json");
        BufferedReader br = new BufferedReader(new FileReader(jsonFile));
        String str = null;
        String json = "";
        while ((str = br.readLine()) != null) {
            json = json + str + "\n";
        }
        JSONArray jsonArray = JSON.parseArray(json);
        String provinceStr = "";
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject province = jsonArray.getJSONObject(i);
            if (province.getJSONArray("childs").size() > 1) {
                JSONArray childs = province.getJSONArray("childs");
                for (int i1 = 0; i1 < childs.size(); i1++) {
                    provinceStr += childs.getJSONObject(i1).getString("name") + ",";
                }
            }
        }
        System.out.println(provinceStr);
    }
}
