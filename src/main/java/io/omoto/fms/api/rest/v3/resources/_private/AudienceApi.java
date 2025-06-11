package io.omoto.fms.api.rest.v3.resources._private;

import com.google.gson.Gson;
import io.omoto.fms.api.rest.v3.messages.ApiMessage;
import io.omoto.fms.api.rest.v3.messages.ApiMessageProvider;
import io.omoto.fms.api.rest.v3.vo.AudienceNewVO;
import io.omoto.fms.api.rest.v3.vo.AudienceVO;
import io.omoto.fms.controllers.audience.AudienceController;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static io.omoto.fms.commons.constants.Constants.API_SUCCESS_MESSAGE;


@RestController
@RequestMapping(path = "/private/audience")
@CrossOrigin("*")
public class AudienceApi {


    public static final String AUDIENCE_CREATION_CONTEXT = "Audience creation context";

    public static final String AUDIENCE_DELETION_CONTEXT = "Audience deletion context";
    @Autowired
    private AudienceController audienceController;

    @PostMapping("/createAudience")
    public ApiMessage createAudience(@RequestBody AudienceVO audienceVO) {
       // System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        dataBean.setMessage(audienceController.createAudience(audienceVO));
        return ApiMessageProvider.provides(dataBean, null, AUDIENCE_CREATION_CONTEXT, "createAudience.post");
    }

    @PostMapping("/createAudience/upload")
    public ApiMessage createAudienceUpload(@RequestParam("file") MultipartFile multipartFile,
                                           @RequestParam("audience") String audience) throws IOException, JSONException {
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        Gson gson = new Gson();
        AudienceVO audienceVO = gson.fromJson(audience, AudienceVO.class);
        dataBean.setMessage(audienceController.createAudience(audienceVO, multipartFile));
        return ApiMessageProvider.provides(dataBean, new ApiMessage.ParamsBean("params", audienceVO), AUDIENCE_CREATION_CONTEXT, "createAudience.post");
    }

    @GetMapping("/getAllAudience")
    public ApiMessage getAllAudience(@RequestParam("account_id") long accountId, @RequestParam("user_id") Long userId) {
        AudienceVO audienceVO = new AudienceVO();
        audienceVO.setAccountId(accountId);
        audienceVO.setUserId(userId);
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        dataBean.setMessage("Success");
        dataBean.setKind("Audience");
        dataBean.setResult(audienceController.getAllAudience(audienceVO));
        ApiMessage.ParamsBean paramsBean = new ApiMessage.ParamsBean("account_id", accountId);
        return ApiMessageProvider.provides(dataBean, paramsBean, "Get all the audience belongs to particular account", "getAllAudience.Get");
    }

    @PostMapping("/saveAudience")
    public ApiMessage saveAudience(@RequestBody AudienceNewVO audienceVO) {
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        dataBean.setMessage(audienceController.saveAudience(audienceVO));
        return ApiMessageProvider.provides(dataBean, null, AUDIENCE_CREATION_CONTEXT, "saveAudience.post");
    }

    @PostMapping("/save")
    public ApiMessage save(@RequestBody AudienceNewVO audienceVO) {
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        dataBean.setMessage(audienceController.save(audienceVO));
        return ApiMessageProvider.provides(dataBean, null, AUDIENCE_CREATION_CONTEXT, "saveAudience.post");
    }

    @GetMapping("/getUserDefinedFields")
    public ApiMessage getUserDefinedFields(@RequestParam("account_id") long accountId) {
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        dataBean.setResult(audienceController.getUserDefinedFields(accountId));
        return ApiMessageProvider.provides(dataBean, null, AUDIENCE_CREATION_CONTEXT, "getUserDefinedFields.get");
    }

    @PutMapping()
    public ApiMessage editAudience(@RequestBody AudienceVO audienceVO) {
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        audienceController.updateAudience(audienceVO);
        dataBean.setMessage(API_SUCCESS_MESSAGE);
        return ApiMessageProvider.provides(dataBean, null, AUDIENCE_CREATION_CONTEXT, "editAudience.post");
    }

    @DeleteMapping("{audienceId}")
    public ApiMessage deleteAudience(@PathVariable String audienceId) {
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        AudienceVO audienceVO = new AudienceVO();
        audienceVO.setAudienceId(audienceId);
        audienceController.deleteAudience(audienceVO);
        dataBean.setMessage(API_SUCCESS_MESSAGE);
        return ApiMessageProvider.provides(dataBean, null, AUDIENCE_DELETION_CONTEXT, "deleteAudience.delete");
    }

    @DeleteMapping()
    public ApiMessage deleteAudience(@RequestBody List<String> audienceIdList) {
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        AudienceVO audienceVO = new AudienceVO();
        audienceVO.setAudienceIdList(audienceIdList);
        audienceController.deleteAudience(audienceVO);
        dataBean.setMessage(API_SUCCESS_MESSAGE);
        return ApiMessageProvider.provides(dataBean, null, AUDIENCE_DELETION_CONTEXT, "deleteAudience.delete");
    }
}
