package com.dnd.menu;

import com.dnd.character.Character;
import com.dnd.character.Warrior;
import com.dnd.character.Wizard;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
   Scanner sc = new Scanner(System.in);
   protected void introMenu()
   {
      System.out.println("Entrez le numéro de l'option choisie :");
   }
   protected int isValidResponse(String response)
   {
      int validatedResponse = 0;
      try {
         if (response.matches("^[1-9]$"))
         {
            validatedResponse =  Integer.parseInt(response);
         }
         else
         {
            throw new InputMismatchException();
         }
      } catch (InputMismatchException e) {
         System.out.println("La réponse entrée n'est pas valide");
      }
      return validatedResponse;
   }
}

