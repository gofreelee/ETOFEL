package chatmodule.util;

import chatmodule.bean.Group;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

/**
 * @ClassName GroupJsonSerializer
 * @Author 11214
 * @Date 2020/6/17
 * @Description TODO
 */
public class GroupJsonSerializer implements JsonSerializer<Group> {
    @Override
    public JsonElement serialize(Group group, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        object.addProperty("grpId", String.valueOf(group.getGrpId()));
        object.addProperty("grpName", group.getGrpName());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        object.addProperty("grpCreateTime", dateFormat.format(group.getGrpCreateTime()));
        object.addProperty("grpDescription", group.getGrpDescription());
        object.addProperty("grpRule", group.getGrpRule());
        object.addProperty("grpType", group.getGrpType());
        object.addProperty("grpPortrait", group.getGrpPortrait());
        object.addProperty("grpCreator", group.getGrpCreator());
        object.addProperty("grpStatus", group.getGrpStatus());
        return object;
    }
}
