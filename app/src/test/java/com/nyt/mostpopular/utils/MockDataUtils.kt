package com.nyt.mostpopular.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nyt.mostpopular.repository.models.Media
import com.nyt.mostpopular.repository.models.MostViewedResponse
import java.lang.reflect.Type
import com.nyt.mostpopular.repository.models.Result

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
object MockDataUtils {

    fun getMockedSuccessMedia(): List<Media> {

        val response = "[\n" +
            "        {\n" +
            "          \"type\": \"image\",\n" +
            "          \"subtype\": \"photo\",\n" +
            "          \"caption\": \"President Trump’s positive test result posed immediate challenges for the future of his campaign with barely a month until Election Day.\",\n" +
            "          \"copyright\": \"Erin Schaff/The New York Times\",\n" +
            "          \"approved_for_syndication\": 1,\n" +
            "          \"media-metadata\": [\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/02dc-virus-trump-sub-thumbStandard.jpg\",\n" +
            "              \"format\": \"Standard Thumbnail\",\n" +
            "              \"height\": 75,\n" +
            "              \"width\": 75\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/merlin_177879399_b71eae36-09c6-4b20-91bc-172b699f76bb-mediumThreeByTwo210.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo210\",\n" +
            "              \"height\": 140,\n" +
            "              \"width\": 210\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/merlin_177879399_b71eae36-09c6-4b20-91bc-172b699f76bb-mediumThreeByTwo440.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo440\",\n" +
            "              \"height\": 293,\n" +
            "              \"width\": 440\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]"

        val type: Type = object : TypeToken<List<Media>>() {}.type

        return Gson().fromJson(response, type)

    }


    fun getMockedFailureMedia(): List<Media> {

        val response = "[]"
        val type: Type = object : TypeToken<List<Media>>() {}.type
        return Gson().fromJson(response, type)

    }


    fun getMockedResponse(): String {

        return "[\n" +
            "    {\n" +
            "      \"uri\": \"nyt://article/de217dd9-3383-574a-9eaf-c0303570e794\",\n" +
            "      \"url\": \"https://www.nytimes.com/2020/10/02/us/politics/trump-covid.html\",\n" +
            "      \"id\": 100000007137500,\n" +
            "      \"asset_id\": 100000007137500,\n" +
            "      \"source\": \"New York Times\",\n" +
            "      \"published_date\": \"2020-10-02\",\n" +
            "      \"updated\": \"2020-10-03 17:28:04\",\n" +
            "      \"section\": \"U.S.\",\n" +
            "      \"subsection\": \"Politics\",\n" +
            "      \"nytdsection\": \"u.s.\",\n" +
            "      \"adx_keywords\": \"Coronavirus (2019-nCoV);United States Politics and Government;Presidents and Presidency (US);Tests (Medical);Twenty-Fifth Amendment (US Constitution);Presidential Election of 2020;Trump Coronavirus Positive Result;Trump, Donald J\",\n" +
            "      \"column\": null,\n" +
            "      \"byline\": \"By Peter Baker and Maggie Haberman\",\n" +
            "      \"type\": \"Article\",\n" +
            "      \"title\": \"Trump Tests Positive for the Coronavirus\",\n" +
            "      \"abstract\": \"The president’s result came after he spent months playing down the severity of the outbreak that has killed more than 207,000 in the United States and hours after insisting that “the end of the pandemic is in sight.”\",\n" +
            "      \"des_facet\": [\n" +
            "        \"Coronavirus (2019-nCoV)\",\n" +
            "        \"United States Politics and Government\",\n" +
            "        \"Presidents and Presidency (US)\",\n" +
            "        \"Tests (Medical)\",\n" +
            "        \"Twenty-Fifth Amendment (US Constitution)\",\n" +
            "        \"Presidential Election of 2020\",\n" +
            "        \"Trump Coronavirus Positive Result\"\n" +
            "      ],\n" +
            "      \"org_facet\": [\n" +
            "        \n" +
            "      ],\n" +
            "      \"per_facet\": [\n" +
            "        \"Trump, Donald J\"\n" +
            "      ],\n" +
            "      \"geo_facet\": [\n" +
            "        \n" +
            "      ],\n" +
            "      \"media\": [\n" +
            "        {\n" +
            "          \"type\": \"image\",\n" +
            "          \"subtype\": \"photo\",\n" +
            "          \"caption\": \"President Trump’s positive test result posed immediate challenges for the future of his campaign with barely a month until Election Day.\",\n" +
            "          \"copyright\": \"Erin Schaff/The New York Times\",\n" +
            "          \"approved_for_syndication\": 1,\n" +
            "          \"media-metadata\": [\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/02dc-virus-trump-sub-thumbStandard.jpg\",\n" +
            "              \"format\": \"Standard Thumbnail\",\n" +
            "              \"height\": 75,\n" +
            "              \"width\": 75\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/merlin_177879399_b71eae36-09c6-4b20-91bc-172b699f76bb-mediumThreeByTwo210.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo210\",\n" +
            "              \"height\": 140,\n" +
            "              \"width\": 210\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/merlin_177879399_b71eae36-09c6-4b20-91bc-172b699f76bb-mediumThreeByTwo440.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo440\",\n" +
            "              \"height\": 293,\n" +
            "              \"width\": 440\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"eta_id\": 0\n" +
            "    }\n" +
            "  ]"
    }


    fun getMockedResults(): List<Result> {

        val response = getMockedResponse()
        val type: Type = object : TypeToken<List<Result>>() {}.type
        return Gson().fromJson(response, type)

    }


    private fun getMockedMostViewedResponse(): String {

        return "{\n" +
            "  \"status\": \"OK\",\n" +
            "  \"copyright\": \"Copyright (c) 2020 The New York Times Company.  All Rights Reserved.\",\n" +
            "  \"num_results\": 20,\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"uri\": \"nyt://article/de217dd9-3383-574a-9eaf-c0303570e794\",\n" +
            "      \"url\": \"https://www.nytimes.com/2020/10/02/us/politics/trump-covid.html\",\n" +
            "      \"id\": 100000007137500,\n" +
            "      \"asset_id\": 100000007137500,\n" +
            "      \"source\": \"New York Times\",\n" +
            "      \"published_date\": \"2020-10-02\",\n" +
            "      \"updated\": \"2020-10-03 17:28:04\",\n" +
            "      \"section\": \"U.S.\",\n" +
            "      \"subsection\": \"Politics\",\n" +
            "      \"nytdsection\": \"u.s.\",\n" +
            "      \"adx_keywords\": \"Coronavirus (2019-nCoV);United States Politics and Government;Presidents and Presidency (US);Tests (Medical);Twenty-Fifth Amendment (US Constitution);Presidential Election of 2020;Trump Coronavirus Positive Result;Trump, Donald J\",\n" +
            "      \"column\": null,\n" +
            "      \"byline\": \"By Peter Baker and Maggie Haberman\",\n" +
            "      \"type\": \"Article\",\n" +
            "      \"title\": \"Trump Tests Positive for the Coronavirus\",\n" +
            "      \"abstract\": \"The president’s result came after he spent months playing down the severity of the outbreak that has killed more than 207,000 in the United States and hours after insisting that “the end of the pandemic is in sight.”\",\n" +
            "      \"des_facet\": [\n" +
            "        \"Coronavirus (2019-nCoV)\",\n" +
            "        \"United States Politics and Government\",\n" +
            "        \"Presidents and Presidency (US)\",\n" +
            "        \"Tests (Medical)\",\n" +
            "        \"Twenty-Fifth Amendment (US Constitution)\",\n" +
            "        \"Presidential Election of 2020\",\n" +
            "        \"Trump Coronavirus Positive Result\"\n" +
            "      ],\n" +
            "      \"org_facet\": [\n" +
            "        \n" +
            "      ],\n" +
            "      \"per_facet\": [\n" +
            "        \"Trump, Donald J\"\n" +
            "      ],\n" +
            "      \"geo_facet\": [\n" +
            "        \n" +
            "      ],\n" +
            "      \"media\": [\n" +
            "        {\n" +
            "          \"type\": \"image\",\n" +
            "          \"subtype\": \"photo\",\n" +
            "          \"caption\": \"President Trump’s positive test result posed immediate challenges for the future of his campaign with barely a month until Election Day.\",\n" +
            "          \"copyright\": \"Erin Schaff/The New York Times\",\n" +
            "          \"approved_for_syndication\": 1,\n" +
            "          \"media-metadata\": [\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/02dc-virus-trump-sub-thumbStandard.jpg\",\n" +
            "              \"format\": \"Standard Thumbnail\",\n" +
            "              \"height\": 75,\n" +
            "              \"width\": 75\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/merlin_177879399_b71eae36-09c6-4b20-91bc-172b699f76bb-mediumThreeByTwo210.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo210\",\n" +
            "              \"height\": 140,\n" +
            "              \"width\": 210\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/10/04/us/politics/02dc-virus-trump-sub/merlin_177879399_b71eae36-09c6-4b20-91bc-172b699f76bb-mediumThreeByTwo440.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo440\",\n" +
            "              \"height\": 293,\n" +
            "              \"width\": 440\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"eta_id\": 0\n" +
            "    }\n" +
            "  ]\n" +
            "}"


    }

    fun getMockedNewsResponse(): MostViewedResponse {

        val response = getMockedMostViewedResponse()
        val type: Type = object : TypeToken<MostViewedResponse>() {}.type
        return Gson().fromJson(response, type)

    }

}