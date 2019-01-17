package pie.bert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private int guessCount = 10;

    @Autowired
    private Game game;

    @PostConstruct
    public void init() {
        LOG.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You've guessed it! The number was: " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You've lost! The number was: " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number tange!";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " guesses left!";
        }
    }
}