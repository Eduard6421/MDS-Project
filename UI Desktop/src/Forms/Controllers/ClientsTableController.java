package Forms.Controllers;

import Controllers.ClientsController;
import Forms.ClientsTable;
import Models.Client;
import Utils.Converters;
import Utils.GlobalData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class ClientsTableController implements ActionListener {

    private ClientsTable form;

    private boolean focus = true;

    private CompanyMenuController parentController = null;

    public ClientsTableController() throws SQLException {

        form = new ClientsTable(this);
        form.setVisible(true);

        fillTable();

    }

    public ClientsTable getForm() {
        return form;
    }

    public ClientsTableController(CompanyMenuController parentController) throws SQLException {

        this.parentController = parentController;
        this.parentController.setWindowInvisible();

        form = new ClientsTable(this);
        form.setVisible(true);

        fillTable();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        String command = evt.getActionCommand();

        if (focus) {
            switch (command) {
                case "Back":
                    form.setVisible(false);
                    form.dispose();
                    parentController.setWindowVisible();
                    break;
            }
        }
    }

    public void toggleFocus() {
        focus = !focus;
    }

    public void setWindowInvisible() {
        form.setVisible(false);
    }

    public void setWindowVisible() {
        form.setVisible(true);
    }

    public void closeWindow() {
        form.setVisible(false);
        form.dispose();
    }

    public void fillTable() throws SQLException {

        List<Object[]> rows = new ArrayList<>();

        List<Client> clients = new ArrayList<>();
        
        String nume = GlobalData.getCompanyName();

        clients = (List<Client>) ClientsController.getAll(GlobalData.getCompanyName());

        for (Client client : clients) {

            Object[] row = new Object[6];
            row[0] = client.getUsername();
            row[1] = client.getFirstName();
            row[2] = client.getLastName();
            row[3] = client.getAddress();
            row[4] = client.getPhone();
            row[5] = client.getEmail();

            rows.add(row);
        }

        form.showPopulation(rows);

    }
}
