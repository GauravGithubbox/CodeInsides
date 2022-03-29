package com.knoldus.codeinsights.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PullRequestService.class})
@ExtendWith(SpringExtension.class)
class PullRequestServiceTest {
    @Autowired
    private PullRequestService pullRequestService;

    @Test
    @Disabled("TODO: This test is incomplete")
    void testGetCommits() throws JsonProcessingException {
        // TODO: This test is incomplete.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        this.pullRequestService.getCommits("Workspace", "Repo Slug", 123);
    }

    @Test
    void testGetCommits2() throws JsonProcessingException {
        assertTrue(this.pullRequestService.getCommits(null, "Repo Slug", 123).isEmpty());
    }

    @Test
    void testGetCommits3() throws JsonProcessingException {
        assertTrue(this.pullRequestService.getCommits("Workspace", null, 123).isEmpty());
    }

    @Test
    void testGetCommits4() throws JsonProcessingException {
        assertTrue(this.pullRequestService.getCommits("Workspace", "Repo Slug", 0).isEmpty());
    }
}

