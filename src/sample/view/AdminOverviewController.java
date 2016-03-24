package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.*;
import sample.model.Song;

/**
 * Created by marospadar on 24.03.16.
 */
public class AdminOverviewController {

    @FXML
    private TableView<Song> songTable;
    @FXML
    private TableColumn<Song, String> nameColumn;
    @FXML
    private TableColumn<Song, String> interpretColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label interpretLabel;
    @FXML
    private Label albumLabel;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField interpretTextField;

    // Reference to the main application.
    private Main main;
    private Song song;

    public AdminOverviewController(){

    }

    @FXML
    private void initialize() {

        // Initialize the song table with the two columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        interpretColumn.setCellValueFactory(cellData -> cellData.getValue().interpretProperty());

        // Clear person details.
        showSongDetail(null);

        // Listen for selection changes and show the person details when changed.
        songTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSongDetail(newValue));

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;

        // Add observable list data to the table
        songTable.setItems(main.getSongData());
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param song the person or null
     */
    private void showSongDetail(Song song) {
        if (song != null) {
            // Fill the labels with info from the person object.
           // nameTextField.setText(song.getName());
           // interpretTextField.setText(song.getInterpret());
          //  streetLabel.setText(person.getStreet());
           // postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
           // cityLabel.setText(person.getCity());

            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
//            nameTextField.setText("");
  //          interpretTextField.setText("");
            //streetLabel.setText("");
            //postalCodeLabel.setText("");
            //cityLabel.setText("");
            //birthdayLabel.setText("");
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteSong() {
        int selectedIndex = songTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            songTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Song Selected");
            alert.setContentText("Please select a song in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Song tempPerson = new Song();
        boolean okClicked = main.showPersonEditDialog(tempPerson);
        if (okClicked) {
            main.getSongData().add(tempPerson);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Song selectedPerson = songTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = main.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showSongDetail(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }




}
