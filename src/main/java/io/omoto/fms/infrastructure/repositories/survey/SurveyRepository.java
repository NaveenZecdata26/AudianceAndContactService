package io.omoto.fms.infrastructure.repositories.survey;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.omoto.fms.commons.constants.Constants;
import io.omoto.fms.domains.survey.Survey;
import io.omoto.fms.domains.survey.SurveyUrl;
import io.omoto.fms.infrastructure.entities.mongo.SurveyDocument;
//import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.codehaus.jackson.type.TypeReference;

import java.util.Optional;

@Component
public class SurveyRepository {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SurveyUrlRepository surveyUrlRepository;

    @Autowired
    private SurveyMongoRepository surveyMongoRepository;





    public SurveyUrl getActiveSurveyUrlBySurveyDocumentId(Survey survey) {
        System.out.println("Survey document id: "+survey.getSurveyDocumentId());
        return objectMapper.convertValue(
                surveyUrlRepository.findBySurveyDocumentIdAndStatus(survey.getSurveyDocumentId(), Constants.ACTIVE),
                SurveyUrl.class);
    }

    public String getSurveyType(String surveyDocumentId) {
        Optional<SurveyDocument> surveyDocument = surveyMongoRepository.findById(surveyDocumentId);
        if (surveyDocument.isPresent()){
            return surveyDocument.get().getSurveyType();
        }else{
            return "REGULAR";
        }
    }


}
