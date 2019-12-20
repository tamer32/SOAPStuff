package com.app.test.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.google.common.base.Predicate;
import com.third.iter.config.SpringConfig;
import com.third.iter.service.UserManagmentService;
import com.third.iter.service.bean.PlayerInfoBean;
import com.third.iter.service.entities.heroes.PlayerInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration
public class UserControllerTest {
  private MockMvc mockMvc;
  @Autowired private WebApplicationContext wac;
  @Autowired private UserManagmentService userService;
  private PlayerInfo player;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    player = new PlayerInfo("Gosho", "Bowman");
  }

  @Test
  public void testCreateUserRedirect() throws Exception {
    mockMvc.perform(get("/registerPage")).andExpect(view().name("index"));
  }

  @Test
  public void testCreateUser() throws Exception {
    PlayerInfoBean bean = new PlayerInfoBean("Pesho", "Warrior");
    mockMvc
        .perform(post("/createUser").flashAttr("playerInfoBean", bean))
        .andExpect(status().is3xxRedirection());
    PlayerInfo player = userService.transformToPlayerInfo(bean);
    Predicate<PlayerInfo> predicate =
        pl ->
            pl.getUsername().equals(player.getUsername())
                && pl.getPlayerClass().equals(player.getPlayerClass());

    assertThat(userService.listUsers().stream().anyMatch(predicate)).isTrue();
  }

  @Test
  public void testDeleteUser() throws Exception {

    userService.createUser(player);
    mockMvc
        .perform(get("/deletePage/" + player.getId()))
        .andExpect(status().is3xxRedirection())
        .andExpect(model().attribute("playerInfoBean", Matchers.any(PlayerInfoBean.class)));
    assertThat(userService.listUsers()).doesNotContain(player);
  }

  @Test
  public void testModifyingPage() throws Exception {
    PlayerInfo player = new PlayerInfo("Gosho", "Rogue");
    userService.createUser(player);
    mockMvc.perform(post("/modifyPage/" + player.getId())).andExpect(status().is2xxSuccessful());
  }
}
