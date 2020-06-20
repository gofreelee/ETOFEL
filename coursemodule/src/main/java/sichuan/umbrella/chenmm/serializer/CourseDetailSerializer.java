package sichuan.umbrella.chenmm.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import sichuan.umbrella.chenmm.bean.CourseDetail;

import java.lang.reflect.Type;

/**
 * @ClassName CourseDetailSerializer
 * @Author 11214
 * @Date 2020/6/20
 * @Description 序列化
 */
public class CourseDetailSerializer implements JsonSerializer<CourseDetail> {
    @Override
    public JsonElement serialize(CourseDetail courseDetail, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        object.addProperty("cdtCosId", courseDetail.getCdtCosId());
        object.addProperty("cdtTchUsername", courseDetail.getCdtTchUsername());
        object.addProperty("cdtGrpId", String.valueOf(courseDetail.getCdtGrpId()));
        object.addProperty("cdtPortrait", courseDetail.getCdtPortrait());
        object.addProperty("cdtPlan", courseDetail.getCdtPlan());
        object.addProperty("cdtPattern", courseDetail.getCdtPattern());
        object.addProperty("cdtGuide", courseDetail.getCdtGuide());
        return object;
    }
}
