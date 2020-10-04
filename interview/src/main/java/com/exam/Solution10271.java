package com.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 19:49
 */
public class Solution10271 {
    public String queryPhoneOperators (String phone) {
        // write code here
        if (phone == null || phone.length() != 11) {
            return "Illegal format";
        }

        Map<String, String> map = new HashMap<>(16);
        map.put("133", "China Telecom");
        map.put("153", "China Telecom");
        map.put("180", "China Telecom");
        map.put("181", "China Telecom");
        map.put("189", "China Telecom");
        map.put("130", "China Unicom");
        map.put("131", "China Unicom");
        map.put("155", "China Unicom");
        map.put("185", "China Unicom");
        map.put("186", "China Unicom");
        map.put("135", "China Mobile");
        map.put("136", "China Mobile");
        map.put("150", "China Mobile");
        map.put("182", "China Mobile");
        map.put("188", "China Mobile");
        String res = "";
        for (int i = 0; i < phone.length(); i++) {
            if (!(phone.charAt(i) >= '0' && phone.charAt(i) <= '9')) {
                return "Illegal format";
            }

            if (i == 0 && phone.charAt(i) != '1') {
                return "Illegal format";
            }

            if (i == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(phone.charAt(0));
                sb.append(phone.charAt(1));
                sb.append(phone.charAt(2));
                if (map.containsKey(sb.toString())) {
                    res = map.get(sb.toString());
                } else {
                    return "Illegal format";
                }
            }
        }

        return res;
    }
}
