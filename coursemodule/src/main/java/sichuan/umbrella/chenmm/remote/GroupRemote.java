package sichuan.umbrella.chenmm.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/group/group/createGroup")
    String createGroup(@RequestParam("grpType") String grpType,
                       @RequestParam("grpName") String grpName,
                       @RequestParam("grpDescription") String grpDescription,
                       @RequestParam("grpRule") String grpRule,
                       @RequestParam("grpPortrait") String grpPortrait,
                       @RequestParam("grpCreator") String grpCreator);
}
