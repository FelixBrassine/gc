package be.technobel.fbrassine.gc.servlets;

import be.technobel.fbrassine.gc.model.Deck;
import be.technobel.fbrassine.gc.model.Player;
import be.technobel.fbrassine.gc.model.PlayingCard;
import be.technobel.fbrassine.gc.service.GameController;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/war")
public class WarServlet extends HttpServlet {


    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Deck deck = new Deck();
        GameController gc = new GameController(deck);
        Player p = new Player("Player");
        gc.addPlayer(p);
        gc.startGame();
        PlayingCard pc = p.getCardToHand(0);

        int rankSuit = (pc.getSuit().value() *100) + pc.getRank().value();

        StringBuffer returnRankSuit = new StringBuffer();
        returnRankSuit.append(rankSuit);
        resp.setContentType("application/json");
        resp.getWriter().write(String.valueOf(returnRankSuit));
    }
}
