package be.technobel.fbrassine.gc.servlets;

import be.technobel.fbrassine.gc.model.Pile;
import be.technobel.fbrassine.gc.model.Player;
import be.technobel.fbrassine.gc.service.GameController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/start")
public class StartGameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int nbPalyer = Integer.parseInt(req.getParameter("nbPlayer"));
        Pile pile = new Pile();
        GameController gc = new GameController(pile);
        for (int i = 0 ; i <nbPalyer  ; i++){
            Player p = new Player("Player"+ i);
            gc.addPlayer(p);
        }
        gc.startGame();
    }
}
