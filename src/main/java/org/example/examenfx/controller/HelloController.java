package org.example.examenfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.examenfx.model.Usuario;
import org.example.examenfx.utils.JavaFXUtil;

public class HelloController {

    @FXML
    private Button botonAñadir;
    @FXML
    private ComboBox<String> ComboBox;
    @FXML
    private TextField CampoCorreo;
    @FXML
    private CheckBox CheckAdministrador;


    @FXML
    private TableColumn<Usuario, String> columnaCorreo;
    @FXML
    private TableColumn<Usuario, String> columnaPlataforma;
    @FXML
    private TableColumn<Usuario, Boolean> columnaAdministrador;


    @FXML
    private TableView<Usuario> tablaUsuarios;

    private ObservableList<Usuario> listaUsuarios;
    @FXML
    private Button BotonBorrar;


    public void initialize(){
        listaUsuarios = FXCollections.observableArrayList();
        tablaUsuarios.setItems(listaUsuarios);


        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        columnaPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        columnaAdministrador.setCellValueFactory(new PropertyValueFactory<>("administrador"));


        ComboBox.getItems().addAll("Windows","Linux","MacOS");
        ComboBox.setValue("Windows");

        botonAñadir.setOnAction(e -> {
            if (CampoCorreo.getText() == null || CampoCorreo.getText().trim().isEmpty()) {
                JavaFXUtil.showModal(Alert.AlertType.WARNING, "Campo Vacío", null, "El campo de correo no puede estar vacío.");
                return;
            }

            Usuario usuario = new Usuario();
            usuario.setCorreo(CampoCorreo.getText());
            usuario.setPlataforma(ComboBox.getValue());
            usuario.setAdministrador(CheckAdministrador.isSelected());

            listaUsuarios.add(usuario);

            CampoCorreo.clear();
            ComboBox.setValue("Windows");
            CheckAdministrador.setSelected(false);
        });


        BotonBorrar.setOnAction(e->{
            listaUsuarios.clear();
        });

        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                mostrarDetallesUsuario(newSelection);
            }
        });
    }

    private void mostrarDetallesUsuario(Usuario usuario) {
        String detalles = "Correo: " + usuario.getCorreo() + "\n" +
                          "Plataforma: " + usuario.getPlataforma() + "\n" +
                          "Es Administrador: " + (usuario.getAdministrador() ? "Sí" : "No");

        JavaFXUtil.showModal(Alert.AlertType.INFORMATION, "Detalles del Usuario", "Información del usuario seleccionado:", detalles);
    }
}
