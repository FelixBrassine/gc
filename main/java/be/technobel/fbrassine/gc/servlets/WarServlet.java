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

        resp.setContentType("/js/index.jsx");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        Deck deck = new Deck();
        GameController gc = new GameController(deck);
        gc.run();
        Player p = new Player("Player");
        gc.addPlayer(p);

        List<PlayingCard> flipCards = gc.flipCards();
        String rankSuit = this.gson.toJson((flipCards.get(0).getSuit().value() *100) + flipCards.get(0).getRank().value());
//        resp.getWriter().append(rankSuit);
        out.print(rankSuit);
        out.flush();
        out.close();
    }
}
