package dat.carport.control;

import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SVGTest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        SVG svg = new SVG(0, 0, "0 0 855 690", 100, 100);
        svg.addRect(10, 20, 100, 200);
        svg.addRect(400, 100, 50, 200);
        svg.addLine(0, 0, 100, 100, false);
        svg.addLine(0, 50, 100, 150, true);
        request.setAttribute("svgDrawing", svg.toString());
        return "svgtest";
    }
}
