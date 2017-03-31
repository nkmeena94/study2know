package com.study2know.api;

/*import com.xeno.core.entity.Reward;
import com.xeno.core.entity.Segment;*/

import java.util.Set;

/**
 * Created by anuj on 26/10/16.
 */
public class XenoProfile {
    /**
     * {"user_id":1,
     * "name":"Nirav Devpura",
     * "email":"nirav@xeno.in",
     * "phone":"9999789444",
     * "image":"https:\/\/graph.facebook.com\/10205595616230876\/picture?type=large",
     * "status":1,
     * "isNewUser":false,
     * "currentPoints":51,
     * "earnPoints":1807,
     * "burnPoints":1756,
     * "pointsEarned":0,
     * "isFirstTimeHere":false,
     * "eligible_rewards":{
     * "count":3,
     * "rewards":[
     * {
     * "id":31,
     * "name":"Dessert On The House!",
     * "points":10,
     * "type":"normal",
     * "claims":56,
     * "expiry_date":"2015-04-30 00:00:00",
     * "request_pending":0,
     * "status":1
     * },
     * {
     * "id":77,
     * "name":"Get a free scarf",
     * "points":25,
     * "type":"normal",
     * "claims":5,
     * "expiry_date":null,
     * "request_pending":0,
     * "status":1
     * },
     * {
     * "id":32,
     * "name":"A Meal For 2 You'll Remember Forever",
     * "points":100,
     * "type":"normal",
     * "claims":45,
     * "expiry_date":"2015-04-30 00:00:00",
     * "request_pending":0,"status":1
     * }
     * ]
     * },
     * "presentSegments":[
     * {
     * "id":22,
     * "name":"Founders",
     * "color":"2e2e2e",
     * "description":"Manually Selected",
     * "forced":true,
     * "pid":3
     * },
     * {
     * "id":28,
     * "name":"Loyal",
     * "color":"41A317",
     * "description":"Last Visited is after 1 month\r\nNo. of Visits are greater than 5",
     * "forced":false,
     * "pid":3
     * }
     * ],
     * "code":"0102492a233c8ae010db12506cfbef79",
     * "isNameAvailable":true,
     * "canSendFeedback":true,
     * "canSeePointGain":true
     * }
     */

    public Long user_id;
    public String name;
    public String email;
    public String phone;
    public String image;
    public String status;
    public String isNewUser;
    public String currentPoints;
    public int earnPoints;
    public int burnPoints;
    public int pointsEarned;
    public boolean isFirstTimeHere;
    public String code;
    public boolean isNameAvailable;
    public boolean canSendFeedback;
    public boolean canSeePointGain;
    public EligibleRewards eligible_rewards;
  /*  public Set<Segment> presentSegments;*/

    public static class EligibleRewards {
        public int count;
/*        public Set<Reward> rewards;*/
    }
}

