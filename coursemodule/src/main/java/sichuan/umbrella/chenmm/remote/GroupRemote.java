package sichuan.umbrella.chenmm.remote;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sichuan.umbrella.chenmm.bean.Group;

/**
 * @ClassName GroupRemote
 * @Author 11214
 * @Date 2020/6/20
 * @Description 远程调用group模块代码
 */
@FeignClient(name = "group")
public interface GroupRemote {
    @GetMapping("/group/group/randomGroup")
    String randomGroupIds(@RequestParam("need") int need);

    @PostMapping(value = "/group/group/createGroup2")
    String createGroup(@RequestBody Group group);
}
