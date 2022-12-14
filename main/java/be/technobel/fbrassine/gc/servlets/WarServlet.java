package be.technobel.fbrassine.gc.servlets;

import be.technobel.fbrassine.gc.model.Deck;
import be.technobel.fbrassine.gc.model.Player;
import be.technobel.fbrassine.gc.service.GameController;
import be.technobel.fbrassine.gc.service.GameState;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/war")
public class WarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Deck deck = new Deck();
        GameController gc = new GameController(deck);
        gc.run();
        Player p = new Player("Player");
        gc.addPlayer(p);
    }
}
