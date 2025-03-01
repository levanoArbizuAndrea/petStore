@ActualizoUnaMascota
Feature: Actualizar una mascota

  @PutPetStore
  Scenario Outline: Actualizar una mascota
    Given que soy un usuario autorizado para interactuar con las APIs de swagger
    When realizo una actualización de la mascota con <ID> modificando su nombre <NOMBRE> y su estado <ESTADO>
    Then se valida la ejecucion <CODIGO>
    Examples:
      | ID | NOMBRE  | ESTADO     | CODIGO |
      | 703403 | Zeus | available | 200    |
      | 703404 | Shoby| available | 200    |