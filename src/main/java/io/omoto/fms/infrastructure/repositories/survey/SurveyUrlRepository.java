package io.omoto.fms.infrastructure.repositories.survey;

import io.omoto.fms.infrastructure.entities.mysql.SurveyUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venkatesh Gowda on 8/2/18.
 */

@Repository
interface  SurveyUrlRepository extends JpaRepository<SurveyUrlEntity,Long> {

    @Query(nativeQuery = true,
            value = "Select * from survey_url where survey_id = :survey_id and type = :type and status = :status")
    SurveyUrlEntity findBySurveyIdAndTypeAndStatus(@Param("survey_id") Long surveyId,
                                                   @Param("type")String type,
                                                   @Param("status") String status);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "update survey_url set status = :status where id = :id")
    void updateSurveyUrlStatus(@Param("id") Long id,
                               @Param("status") String status);

    @Query(nativeQuery = true, value = "select status from survey_url where id = :id")
    String getStatusById(@Param("id") Long id);


    @Query(nativeQuery = true,
            value = "Select * from survey_url where survey_document_id = :survey_document_id and status = :status")
    SurveyUrlEntity findBySurveyDocumentIdAndStatus(@Param("survey_document_id") String surveyDocumentId,
                                                    @Param("status") String status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE survey_url SET status = :status WHERE survey_document_id IN :surveyDocumentIds", nativeQuery = true)
    void updateStatusBySurveyDocumentIds(List<String> surveyDocumentIds, String status);

    @Query(value = "SELECT s.token FROM survey_url s WHERE s.survey_document_id = :surveyUrlDocumentId", nativeQuery = true)
    String getSurveyUrlTokenByDocumentId(@Param("surveyUrlDocumentId") String surveyUrlDocumentId);

    @Query(nativeQuery = true, value = "Select short_url from survey_url where survey_document_id = :survey_document_id")
    String findUrlBySurveyId(@Param("survey_document_id") String surveyDocumentId);

}
