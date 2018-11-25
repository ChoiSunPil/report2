package sopt.org.seminar2_review.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;
import sopt.org.seminar2_review.Model.User;

import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController //REST를 위한 전용 Controller 등
public class firstController {
    private static final List<User> userList = new LinkedList<>();


    @GetMapping("")
    public String time() {

        long time = System.currentTimeMillis();

        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        String str = dayTime.format(new Date(time));

        return str;
    }

    @GetMapping("/users")
    public String getUserList(@RequestParam(value = "name", defaultValue = "-1") String name, @RequestParam(value = "part", defaultValue = "-1") String part) {

        List<User> users = new LinkedList<>();
        if (name.compareTo("-1") == 0 && part.compareTo("-1") == 0)
            return userList.toString();

        for (User i : userList) {


            if (i.getName().compareTo(name) == 0) {
                users.add(i);
            }
            if (i.getPart().compareTo(part) == 0) {

            }
            users.add(i);
        }

        if (users.size() == 0)
            return "없습니다";
        else
            return users.toString();
    }


    @GetMapping("/users/{user_idx}")
    public String findUser(@PathVariable final int user_idx) {
        JSONObject jsonObject = new JSONObject();


        for (User i : userList) {
            if (i.getUserIdx() == user_idx) {
                jsonObject.put("name", i.getName());
                jsonObject.put("part", i.getPart());
                jsonObject.put("USerIdx", i.getUserIdx());
                return jsonObject.toJSONString();
            }

        }
        return "없습니다.";


    }


    @PostMapping("/users")
    public void saveUser(@RequestBody final User user) {
        userList.add(user);

    }

    @PutMapping("users/{user_idx}")
    public void updateUser(@PathVariable final int user_idx) {
        for (User i : userList) {
            if (i.getUserIdx() == user_idx) {
                i.setName("최선필");
                i.setPart("서버");
            }

        }

    }

    @DeleteMapping("users/{user_idx}")
    public void deleteUser(@PathVariable final int user_idx) {
        for (User i : userList) {
            if (i.getUserIdx() == user_idx)
                userList.remove(i);

        }

    }


}
