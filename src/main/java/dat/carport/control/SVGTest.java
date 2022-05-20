package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SVGTest extends Command {

    private ConnectionPool connectionPool;

    public SVGTest() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        float carportWidth = 600; // request.getCarportWidth();
        float carportLength = 780; // request.getCarportLength();
        float rafterCount = 15; // stykliste.getRafters();
        float rafterLength = carportWidth;
        float dashLine_x1 = 0;
        float dashLine_x2 = 0;
        float dashLine_y1 = 37;
        float dashLine_y2 = carportWidth- 38;
        String viewBox = String.format("0 0 %f %f", carportLength, carportWidth);
        SVG canvas = new SVG(0, 0, "0 0 800 800", 100, 100, true);
        SVG carport = new SVG(80, 50, viewBox, 75, 75, false);

        // Make the carport svg
        // Roof border
        carport.addRect(0, 0, carportLength-5, carportWidth);
        // Add the poles
        carport.addRect(100, 30, 15, 15);
        carport.addRect(100, carportWidth-35-10, 15, 15);
        carport.addRect(carportLength-100, 30, 15, 15);
        carport.addRect(carportLength-100, carportWidth-35-10, 15, 15);
        if (carportLength-200 > 310) {
            float middlePoleX = carportLength / 2;
            carport.addRect(middlePoleX, 30, 15, 15);
            carport.addRect(middlePoleX, carportWidth-35-10, 15, 15);
        }
        // Add the beams
        carport.addRect(0, 35, carportLength-10, 5.5f);
        carport.addRect(0, carportWidth-35-5, carportLength-10, 5.5f);
        // Add the rafters
        int rafterSpacing = (int) (carportLength / (rafterCount - 1));
        int rafterPlacement = 0;
        for (int x = 0; x < rafterCount; x++) {
            carport.addRect(rafterPlacement, 0, 4.5f, rafterLength);
            if (x == 1) {
                dashLine_x1 = rafterSpacing + 2;
            }
            if (x == ((int) Math.ceil(rafterCount * (2 / 3.0)))) {
                dashLine_x2 = rafterSpacing * x + 2;
            }
            rafterPlacement += rafterSpacing;
        }
        // Add the dashed lines
        carport.addLine(dashLine_x1, dashLine_y1, dashLine_x2, dashLine_y2, true);
        carport.addLine(dashLine_x2, dashLine_y1, dashLine_x1, dashLine_y2, true);

        // Make the canvas SVG
        canvas.addArrow(50, 50, 50, 510);
        canvas.addText(30, 270, 90, Math.round(carportWidth) + " cm");
        canvas.addArrow(80, 540, 678, 540);
        canvas.addText(360, 570, 0, Math.round(carportLength) + " cm");
        canvas.addSVG(carport);

        request.setAttribute("svgDrawing", canvas.toString());
        return "svgtest";
    }
}
