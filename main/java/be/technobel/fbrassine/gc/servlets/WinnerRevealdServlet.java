package be.technobel.fbrassine.gc.servlets;

import be.technobel.fbrassine.gc.model.Pile;
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
import java.util.List;

@WebServlet("/winnerReveald")
public class WinnerRevealdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }
}
