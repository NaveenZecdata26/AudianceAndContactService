package io.omoto.fms.utils;

//import io.omoto.fms.api.rest.v3.vo.SurveyVO;
import io.omoto.fms.commons.constants.Constants;
import org.apache.commons.lang.WordUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Created by Venkatesh Gowda on 11/12/17.
 */
public class CommonUtil {

    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static final String PHONE_REGEX = "^[0-9]{10}$";
    private static final String NAME_REGEX = "^[\\p{L} .-]*\\'?[\\p{L} .-]*";

    private CommonUtil() {
    }

    /**
     * This method validates queueName based on
     * Only alphabets [A-Z] and [', ] are allowed in queueName.
     *
     * @param name to be validated
     * @return true, if satisfies above condition. Otherwise false.
     */
    public static boolean isValidName(String name) {
        return name != null && Pattern.compile(NAME_REGEX).matcher(name).find();
    }

    /**
     * This method validates given
     * string is in valid email format
     *
     * @param email to be validated
     * @return true if given input is in valid email format. otherwise false.
     */
    public static boolean isValidEmail(String email) {
        return email != null && Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE).matcher(email).find();
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && Pattern.compile(PHONE_REGEX).matcher(phone).find();
    }

    /**
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getMD5(String value) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new String(messageDigest
                    .digest(value.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static String[] splitByFirstOccurrence(String value, String split) {
        return value.split(split, 2);
    }

    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    public static String getHtmlContent(SpringTemplateEngine templateEngine, String theme) {
        Context context = new Context();
        return templateEngine.process(theme, context);
    }

    /*public static ResponseVO parseEmailResponse(MultiValueMap<String, Object> body) {
        ResponseVO responseVO = new ResponseVO();

        if (body != null && body.containsKey("surveyId")) {
            responseVO.setChannel("Email2");
            responseVO.setSurveyId(body.get("surveyId").get(0).toString());
            responseVO.setCampaignId(body.get("campaignId").get(0).toString());
            responseVO.setRespondentIdentifier(body.get("respondentIdentifier").get(0).toString());

            body.remove("surveyId");
            body.remove("campaignId");
            body.remove("respondentIdentifier");

            List<ResponseVO.SurveyResponsesEntity> responses = new ArrayList<>();
            final String[][] typeAndQuestionId = {new String[2]};
            body.forEach((k, v) -> {
                ResponseVO.SurveyResponsesEntity surveyResponsesEntity = new ResponseVO.SurveyResponsesEntity();
                typeAndQuestionId[0] = CommonUtil.splitByFirstOccurrence(k, "_");
                surveyResponsesEntity.setQuestionId(Integer.parseInt(typeAndQuestionId[0][1]));
                switch (typeAndQuestionId[0][0]) {
                    case NPS:
                        surveyResponsesEntity.setRating(Integer.parseInt(v.get(0).toString()));
                        break;
                    case DROP_DOWN:
                        surveyResponsesEntity.setAnswerId(Integer.parseInt(v.get(0).toString()));
                        break;
                    case CHOICE:
                        List<ResponseVO.SurveyResponsesEntity.ChoicesEntity> choicesEntities = new ArrayList<>(v.size());
                        ResponseVO.SurveyResponsesEntity.ChoicesEntity choicesEntity;
                        for (Object o : v) {
                            choicesEntity = new ResponseVO.SurveyResponsesEntity.ChoicesEntity();
                            choicesEntity.setChoiceId(Integer.parseInt(o.toString()));
                            choicesEntity.setIsChecked(true);
                            choicesEntities.add(choicesEntity);
                        }
                        surveyResponsesEntity.setChoices(choicesEntities);
                        break;
                    case LONG_TEXT:
                    case SHORT_TEXT:
                    case YES_NO:
                    case DATE:
                        surveyResponsesEntity.setAnswer(String.valueOf(v.get(0)));
                        break;
                    default:
                        break;
                }
                responses.add(surveyResponsesEntity);
            });

            responseVO.setSurveyResponses(responses);
        }

        return responseVO;
    }*/

    public static String getCamelCase(String word) {
        if (word != null) {
            return WordUtils.uncapitalize(WordUtils.capitalize(word, null));
        }return null;
    }

//    public static SurveyVO.SurveyPreview getDefaultSurveyPreviewInformation() {
//        SurveyVO.SurveyPreview surveyPreview = new SurveyVO.SurveyPreview();
//        surveyPreview.setTitle(Constants.DEFAULT_SURVEY_PREVIEW_TITLE);
//        surveyPreview.setDescription(Constants.DEFAULT_SURVEY_PREVIEW_DESCRIPTION);
//        surveyPreview.setImageLink(Constants.DEFAULT_SURVEY_PREVIEW_CARD_IMAGE);
//        surveyPreview.setActive(true);
//        return surveyPreview;
//    }


    public static long getSkip(long pageNumber,long limit) {
        return (pageNumber-1)*limit;
    }

    public static int getRandomNumber(int low, int high){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

    public static int getRandomNumberBetween0To100() {
        return getRandomNumber(1, 100);
    }

    public static int getRandomNumberBetween0To1000(){
        return getRandomNumber(1,1000);
    }

    public static int getRandomNumberBetween10000To12000(){
        return getRandomNumber(10000,12000);
    }
}
