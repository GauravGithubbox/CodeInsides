package com.knoldus.codeinsights.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.node.DoubleNode;
import com.knoldus.codeinsights.dto.Response;
import com.knoldus.codeinsights.service.PullRequestService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PullRequestController.class})
@ExtendWith(SpringExtension.class)
class PullRequestControllerTest {
    @Autowired
    private PullRequestController pullRequestController;

    @MockBean
    private PullRequestService pullRequestService;

    @Test
    void testGetPullRequestsContainCommit() throws Exception {
        when(this.pullRequestService.getPullRequestsContainCommit((String) any(), (String) any(), (String) any()))
                .thenReturn(DoubleNode.valueOf(10.0d));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/codeInsights/commits");
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));

    }

    @Test
    void testGetPullRequestsContainCommit2() throws Exception {
        when(this.pullRequestService.getPullRequestsContainCommit((String) any(), (String) any(), (String) any()))
                .thenReturn(DoubleNode.valueOf(10.0d));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/codeInsights/commits");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("10.0"));
    }

    @Test
    void testGetCommentsForPR() throws Exception {
        when(this.pullRequestService.getComments((String) any(), (String) any(), (Integer) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/codeInsights/comments");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("pullRequestId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetDefaultReviewers() throws Exception {
        when(this.pullRequestService.getDefaultReviewers((String) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/codeInsights/defaultReviewers");
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetDefaultReviewers2() throws Exception {
        when(this.pullRequestService.getDefaultReviewers((String) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/codeInsights/defaultReviewers");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetPRForParticularUser() throws Exception {
        when(this.pullRequestService.getPRForParticularUser((String) any(), (String) any(), (String) any()))
                .thenReturn(new Response());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/codeInsights/user");
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    @Test
    void testGetPRForParticularUser2() throws Exception {
        when(this.pullRequestService.getPRForParticularUser((String) any(), (String) any(), (String) any()))
                .thenReturn(new Response());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/codeInsights/user");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    @Test
    void testGetCommentsForPR2() throws Exception {
        when(this.pullRequestService.getComments((String) any(), (String) any(), (Integer) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/codeInsights/comments");
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("pullRequestId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetCommitsForPR() throws Exception {
        when(this.pullRequestService.getCommits((String) any(), (String) any(), anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/codeInsights/commit");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("pullRequestId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetCommitsForPR2() throws Exception {
        when(this.pullRequestService.getCommits((String) any(), (String) any(), anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/codeInsights/commit");
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("pullRequestId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetPRActivityLogForPullRequestId() throws Exception {
        when(this.pullRequestService.getActivityLogForParticularPR((String) any(), (String) any(), (Integer) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/codeInsights/logs");
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetPRActivityLogForPullRequestId2() throws Exception {
        when(this.pullRequestService.getActivityLogForParticularPR((String) any(), (String) any(), (Integer) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/codeInsights/logs");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.pullRequestController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

