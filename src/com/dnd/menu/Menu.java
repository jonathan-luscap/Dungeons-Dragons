package com.dnd.menu;

import com.dnd.exception.*;

import java.util.Scanner;

public abstract class Menu {
   Scanner sc = new Scanner(System.in);
   protected void introMenu()
   {
      System.out.println("Entrez le numéro de l'option choisie :");
   }
   public abstract void displayChoices();
   protected int isValidIntResponse(String response) throws BadIntException {
      int validatedResponse = 0;

      if (response.matches("^[1-9]$"))
      {
         validatedResponse =  Integer.parseInt(response);
      }
      else
      {
         throw new BadIntException();
      }
      return validatedResponse;
   }
   public String isValidStringResponse(String response) throws BadStringException {
      if (response.matches("^[A-Za-z0-9 '-]{3,20}$"))
      {
         return  response;
      }
      else
      {
         throw new BadStringException();
      }
   }
   public int getIntResponse(){
      int userChoice = 0;
      try
      {
         userChoice = isValidIntResponse(sc.nextLine());
      }
      catch (BadIntException e)
      {
         System.out.println("Veuillez saisir un nombre entier :" + e);
      }
      return userChoice;
   }
   public String getStringResponse(){
      String userInput = "";
      try
      {
         userInput = isValidStringResponse(sc.nextLine());
      }
      catch (BadStringException e)
      {
         System.out.println("Des lettres en minuscule ou majuscule,\n des chiffres, \"'\" apostrophes, \" \" espaces ou \"-\" tirets du 6.");
      }
      return userInput;
   }
   protected void badChoice() {
      System.out.println("Ce choix n'est pas valide.");
   }
}

