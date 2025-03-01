@ActualizoUnaMascota
Feature: Actualizar una mascota

  @PutPetStore
  Scenario Outline: Actualizar una mascota
    Given que soy un usuario autorizado para interactuar con las APIs de swagger
    When realizo una actualizacion de la mascota con <ID> modificando su nombre "<NOMBRE>" y su estado "<ESTADO>"
    Then se valida la ejecucion <CODIGO>

    Examples:
      | ID     | NOMBRE   | ESTADO     | CODIGO |
      | 703403 | Zeus     | available  | 200    |
      | 703404 | Shoby    | available  | 200    |
      | 703405 | Luna     | pending    | 200    |
      | 703406 | Max      | sold       | 200    |
      | 999999 | Ghost    | available  | 404    |
      | 703407 | Rex      | unknown    | 400    |
      | 703408 |          | available  | 400    |
      | 703409 | Bella    | available  | 500    |

