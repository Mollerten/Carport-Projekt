package dat.carport.control;

import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SVGTest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        int rafterSpacing = 55;
        int rafterCount = 15;
        int rafterLength = 600;
        int carportWidth = 600;
        int carportLength = 780;
        int dashLine_x1 = 0;
        int dashLine_x2 = 0;
        int dashLine_y1 = 37;
        int dashLine_y2 = carportWidth- 38;
        String viewBox = String.format("0 0 %d %d", carportLength, carportWidth);
        SVG canvas = new SVG(0, 0, "0 0 800 800", 150, 150, true);
        SVG carport = new SVG(0, 0, viewBox, 100, 100, false);

        // Make the carport svg
        // Add the poles
        for (int i = 100; i < carportLength; i += 310) {
            carport.addRect(i, 30, 15, 15);
            carport.addRect(i, carportWidth-35-10, 15, 15);
        }
        // Add the beams
        carport.addRect(0, 35, carportLength-10, 5.5f);
        carport.addRect(0, carportWidth-35-5, carportLength-10, 5.5f);
        // Add the rafters
        for (int x = 0; x < rafterCount; x++) {
            carport.addRect(rafterSpacing * x, 0, 4.5f, ((float) rafterLength));
            if (x == 1) {
                dashLine_x1 = rafterSpacing + 2;
            }
            if (x == ((int) Math.ceil(rafterCount * (2 / 3.0)))) {
                dashLine_x2 = rafterSpacing * x + 2;
            }
        }
        // Add the dashed lines
        carport.addLine(dashLine_x1, dashLine_y1, dashLine_x2, dashLine_y2, true);
        carport.addLine(dashLine_x2, dashLine_y1, dashLine_x1, dashLine_y2, true);

        // Make the canvas SVG
        canvas.addArrow(50, 50, 50, 500);
        canvas.addSVG(carport);

        request.setAttribute("svgDrawing", canvas.toString());
        return "svgtest";
    }
}
