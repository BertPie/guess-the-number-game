package pie.bert.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pie.bert.service.GameService;
import pie.bert.utils.AttributesNames;
import pie.bert.utils.GameMappings;
import pie.bert.utils.ViewNames;

@Slf4j
@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(GameMappings.PLAY)
    public String play(Model model){
        model.addAttribute(AttributesNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributesNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model: {}", model);

        if(gameService.isGameOver()){
            return ViewNames.GAME_OVER;
        }

        return ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String play(@RequestParam int guess){
        log.info("Guess: {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }
}