@CrearNuevaMascota
Feature: Crear una nueva mascota

  @PostPetStores
  Scenario Outline: Creacion de una nueva mascota
    Given que soy un usuario autorizado para interactuar con las APIs de swagger
    When creo una nueva mascota con <ID> su nombre <NOMBRE> y su estado <ESTADO>
    Then se valida la ejecucion <CODIGO>
    Examples:
      | ID    | NOMBRE  | ESTADO     | CODIGO |
      | 703401 | Nina    | available | 200    |
      | 703402 | Pequeña | available | 200    |