package com.luong.peepxadmin.cucumber.stepdefs;

import com.luong.peepxadmin.PeepxAdminApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = PeepxAdminApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
