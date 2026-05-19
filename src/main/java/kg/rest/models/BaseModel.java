package kg.rest.models;

import kg.rest.JsonUtils;

public abstract class BaseModel {
    public String toJson(){
        return JsonUtils.toJson(this);
    }
}
