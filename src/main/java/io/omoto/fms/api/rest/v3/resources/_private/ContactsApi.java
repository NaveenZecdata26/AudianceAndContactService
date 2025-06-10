package io.omoto.fms.api.rest.v3.resources._private;

import com.google.gson.Gson;
import io.omoto.fms.api.rest.v3.messages.ApiMessage;
import io.omoto.fms.api.rest.v3.messages.ApiMessageProvider;
import io.omoto.fms.api.rest.v3.vo.AudienceVO;
import io.omoto.fms.controllers.audience.AudienceController;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@RequestMapping(path = "/private/contacts")
@CrossOrigin("*")
public class ContactsApi {

    @Autowired
    private AudienceController audienceController;
    @Autowired
    private Gson gson;

    @PostMapping("/upload")
    public ApiMessage upload(@RequestParam("audience") String audience,
                             @RequestParam("file") MultipartFile file) throws IOException, JSONException {

        AudienceVO audienceVO = gson.fromJson(audience, AudienceVO.class);
        audienceController.createAudience(audienceVO,file);
        return null;
    }

    @GetMapping()
    public ApiMessage getContacts(@RequestParam("audienceId") String audienceId,@RequestParam("accountId") Long accountId ) throws IOException, JSONException {
        AudienceVO audienceVO = new AudienceVO();
        audienceVO.setAccountId(accountId);
        audienceVO.setAudienceId(audienceId);
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        dataBean.setResult(audienceController.getContacts(audienceVO));
        return ApiMessageProvider.provides(dataBean, null, "Get contacts", "createAudience.post");
    }

    @GetMapping("/audienceContacts")
    public ApiMessage getContactsByAudience(@RequestParam("audienceId") String audienceId,@RequestParam("accountId") Long accountId ) throws IOException, JSONException {
        AudienceVO audienceVO = new AudienceVO();
        audienceVO.setAccountId(accountId);
        audienceVO.setAudienceId(audienceId);
        ApiMessage.DataBean dataBean = new ApiMessage.DataBean();
        dataBean.setResult(audienceController.getContactsByAudience(audienceVO));
        return ApiMessageProvider.provides(dataBean,null,"Get contacts" ,"createAudience.post");
    }
}
