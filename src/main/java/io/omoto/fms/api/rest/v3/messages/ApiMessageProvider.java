package io.omoto.fms.api.rest.v3.messages;

import io.omoto.fms.utils.CommonUtil;

import static io.omoto.fms.commons.constants.Constants.API_VERSION;

public class ApiMessageProvider {
    public static ApiMessage provides(
            ApiMessage.DataBean dataBean,
            ApiMessage.ParamsBean paramsBeanList,String context,String methodName){
        ApiMessage apiMessage = new ApiMessage();
        apiMessage.setMethod(methodName);
        apiMessage.setContext(context);
        apiMessage.setApiVersion(API_VERSION);
        apiMessage.setData(dataBean);
        apiMessage.setIdentifier(CommonUtil.getUUID());
        apiMessage.setParams(paramsBeanList);

        return apiMessage;
    }

    private ApiMessageProvider(){

    }
}
