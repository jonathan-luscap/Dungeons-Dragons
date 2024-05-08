package com.dnd.menu;

import com.dnd.exception.*;

import java.util.Scanner;

public abstract class Menu {
   Scanner sc = new Scanner(System.in);
   protected void introMenu()
   {
      System.out.println("\n_________________________________________________________________________________________________\n" +
              "Entrez le numéro de l'option choisie :");
   }
   protected int isValidIntResponse() throws BadIntException {
      String response = sc.nextLine();
      int choice = 0;

      if (response.matches("^[1-9]*$"))
      {
         choice =  Integer.parseInt(response);
      }
      else
      {
         throw new BadIntException();
      }
      return choice;
   }
   protected String isValidStringResponse() throws BadStringException {
      String response = sc.nextLine();
      if (response.matches("^[A-Za-z0-9 '-]{3,20}$")) {

      }
      else
      {
         throw new BadStringException();
      }
      return  response;
   }
   public int getIntResponse(){
      int userChoice = 0;
      try
      {
         userChoice = isValidIntResponse();
      }
      catch (BadIntException e)
      {
         System.out.println("Veuillez saisir un nombre entier.");
      }
      return userChoice;
   }
   public String getStringResponse(){
      boolean isNotCorrect = true;
      String userInput = "";
      while (isNotCorrect){
         try
         {
            userInput = isValidStringResponse();
            isNotCorrect = false;
         }
         catch (BadStringException e)
         {
            System.out.println("Des lettres en minuscule ou majuscule, des chiffres, \"'\" apostrophes, \" \" espaces ou \"-\" tirets du 6.");
            System.out.println("Entrer à nouveau, svp.");
         }
      }
      return userInput;
   }
   protected void badChoice() {
      System.out.println("Ce choix n'est pas valide.");
   }
   protected void displaySpace(){
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
   }
   public void pause(int time){
      try
      {
         Thread.sleep(time);
      }
      catch (InterruptedException e)
      {
         System.out.println("Something went wrong with the tempo..." + e);
      }
   }
}

