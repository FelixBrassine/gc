package be.technobel.fbrassine.gc.servlets;

import be.technobel.fbrassine.gc.model.Deck;
import be.technobel.fbrassine.gc.model.Player;
import be.technobel.fbrassine.gc.model.PlayingCard;
import be.technobel.fbrassine.gc.service.GameController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/war")
public class WarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Deck deck = new Deck();
        GameController gc = new GameController(deck);
        gc.run();
        Player p = new Player("Player");
        gc.addPlayer(p);
        List<PlayingCard> flipCards = gc.flipCards();
        int suitPlayer = flipCards.get(0).getSuit().value();
        int rankPlayer = flipCards.get(0).getRank().value();
        req.setAttribute("suit",suitPlayer);
        req.setAttribute("rank",rankPlayer);
        req.getRequestDispatcher("/js/index.jsx").forward(req, resp);
    }
}
