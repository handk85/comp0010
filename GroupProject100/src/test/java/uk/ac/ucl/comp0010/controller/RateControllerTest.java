package uk.ac.ucl.comp0010.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.ac.ucl.comp0010.model.Movie;
import uk.ac.ucl.comp0010.model.Rate;
import uk.ac.ucl.comp0010.repository.MovieRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class RateControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MovieRepository movieRepository;

  Movie movie;

  @BeforeEach
  void beforeEach() {
    movie = new Movie();
    movie.setTitle("Daedpool");
    movie = movieRepository.save(movie);
  }

  @Test
  void addRateTest() throws JsonProcessingException, Exception {
    Map<String, Integer> params = new HashMap<String, Integer>();
    params.put("movie_id", 1);
    params.put("score", 4);

    MvcResult action = mockMvc.perform(MockMvcRequestBuilders.post("/rates/addRate")
        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(params)))
        .andReturn();
    assertEquals(HttpStatus.OK.value(), action.getResponse().getStatus());

    Rate rate = objectMapper.readValue(action.getResponse().getContentAsString(), Rate.class);
    assertEquals(movie.getId(), rate.getMovie().getId());
    assertEquals(movie.getTitle(), rate.getMovie().getTitle());
    assertEquals(4, rate.getScore());
    assertNotNull(rate.getId());
  }
}
