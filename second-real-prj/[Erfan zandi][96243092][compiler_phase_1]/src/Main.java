//package com.company;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Main
{

    public static  int[] styles = { Font.ITALIC, Font.BOLD };

    public static ArrayList<Integer> code_for_colors= new ArrayList<Integer>();
    public static String[] code_of_operators_for_parser=new String[34];
    public  static ArrayList<String> code_of_operators_for_parser_2=new ArrayList<String>();


    public static  File input_file= new File("/Users/erfan/Desktop/input_file.tex");
    public static int counter_for_getLines=0;
    public static int counter_for_getchar=0;

    public static ArrayList<String> all_the_lines=new ArrayList<>();
    public static int index=0;

    public static ArrayList<String> kwt=new ArrayList<String>();

    public static String html_string="<html>  <head>  </head>  <body>  ";
    public static  String html_string_2=" <html><head></head><body>";


    // ----->   <font face="  "  size="   "> ST </font>


    public  static void create_html_file()
    {
        try
        {

            File file_html = new File("/Users/erfan/Desktop/output_file.html");

            FileWriter fileWriter = new FileWriter(file_html);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
       /* bufferedWriter.write("<html>" +
                "<head> <title>  This is title </title> </head> " +
                "<body>  <p style='color:blue'>  hello world... </p>  </body>" +
                "</html> ");  */

            bufferedWriter.write(html_string_2);

            bufferedWriter.close();

        }catch (Exception e)
        {

            e.printStackTrace();
        }

    }

    public static void set_operators_code()
    {

        code_of_operators_for_parser_2.add("+");
        code_of_operators_for_parser_2.add("-");
        code_of_operators_for_parser_2.add("*");
        code_of_operators_for_parser_2.add("/");
        code_of_operators_for_parser_2.add("+=");
        code_of_operators_for_parser_2.add("-=");
        code_of_operators_for_parser_2.add("*=");
        code_of_operators_for_parser_2.add("/=");

        code_of_operators_for_parser_2.add("++");
        code_of_operators_for_parser_2.add("--");
        code_of_operators_for_parser_2.add("<");
        code_of_operators_for_parser_2.add("<=");
        code_of_operators_for_parser_2.add(">");
        code_of_operators_for_parser_2.add(">=");
        code_of_operators_for_parser_2.add("!=");
        code_of_operators_for_parser_2.add("==");

        code_of_operators_for_parser_2.add("<-");       // assign ....
        code_of_operators_for_parser_2.add("&&");
        code_of_operators_for_parser_2.add("&");

        code_of_operators_for_parser_2.add(String.valueOf('"'));

        code_of_operators_for_parser_2.add("!");
        code_of_operators_for_parser_2.add(",");
        code_of_operators_for_parser_2.add("[");
        code_of_operators_for_parser_2.add("]");

        code_of_operators_for_parser_2.add("(");
        code_of_operators_for_parser_2.add(")");

        code_of_operators_for_parser_2.add("{");
        code_of_operators_for_parser_2.add("}");


        code_of_operators_for_parser[16]="<-";

        code_of_operators_for_parser[17]="&&"; code_of_operators_for_parser[18]="&";
        code_of_operators_for_parser[19]= String.valueOf('"');

        code_of_operators_for_parser[20]="!";

        code_of_operators_for_parser[21]=",";

        code_of_operators_for_parser[22]="[";
        code_of_operators_for_parser[23]="]";

        code_of_operators_for_parser_2.add(".");
        code_of_operators_for_parser_2.add(";");
        code_of_operators_for_parser_2.add("|");
        code_of_operators_for_parser_2.add("||");

        code_of_operators_for_parser_2.add("^");
        code_of_operators_for_parser_2.add("%");
        //code_of_operators_for_parser_2.add("=");



        code_of_operators_for_parser[8]="++"; code_of_operators_for_parser[9]="--";
        code_of_operators_for_parser[10]="<"; code_of_operators_for_parser[11]="<=";
        code_of_operators_for_parser[12]=">"; code_of_operators_for_parser[13]=">=";
        code_of_operators_for_parser[14]="!="; code_of_operators_for_parser[15]="==";

        code_of_operators_for_parser[0]="+"; code_of_operators_for_parser[1]="-";
        code_of_operators_for_parser[2]="*"; code_of_operators_for_parser[3]="/";
        code_of_operators_for_parser[4]="+="; code_of_operators_for_parser[5]="-=";
        code_of_operators_for_parser[6]="*="; code_of_operators_for_parser[7]="/=";




        code_of_operators_for_parser[24]="(";
        code_of_operators_for_parser[25]=")";

        code_of_operators_for_parser[26]="{";
        code_of_operators_for_parser[27]="}";

        code_of_operators_for_parser[28]=".";

        code_of_operators_for_parser[29]=";";

        code_of_operators_for_parser[30]="^";       // bitwise XOR

        code_of_operators_for_parser[31]="|";       // bitwise OR
        code_of_operators_for_parser[32]="||";      // logical OR

        code_of_operators_for_parser[33]="%";
    }


    public static void set_kwt()
    {
        kwt.add("if");/* code: 34 */  kwt.add("else"); kwt.add("id");  kwt.add("real"); kwt.add("int"); kwt.add("for");
        kwt.add("bool"); kwt.add("String"); kwt.add("void"); kwt.add("loop"); kwt.add("pool"); kwt.add("break"); kwt.add("in_String");
        kwt.add("class"); kwt.add("let"); kwt.add("in_int"); kwt.add("out_int"); kwt.add("String");kwt.add("new"); kwt.add("out_String");
        kwt.add("fi"); kwt.add("while"); kwt.add("rof"); kwt.add("Array"); kwt.add("return");
    }

    public static int scan_char_by_char() {

        String red_string;
        String input;

        if(all_the_lines.get(0).isEmpty())
            return 33;

        input = all_the_lines.get(0);

        //all_the_lines.remove(0);
        int input_size = input.length();
        char lex;
        char flag = '0';
        double help = 0.1;
        String string_comment = "";

        String help_for_lex;

        double icv_after_point = 0;
        double icv = 0;
        int code = -1;

        String icv_string = " ";//code for numbers is 50

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        index = 0;   // it must start with zero...
        lex = input.charAt(index);

        if (lex == '.') System.out.println("Error happened");     // one of error handler of Scanner...


        while (index<=input.length()-2) {

            lex = input.charAt(index);
            help_for_lex = String.valueOf(lex);
            //********************************************************

            if (lex == '"')
            {
                icv_string = String.valueOf(lex);

                lex = input.charAt(++index);

                while (lex != '"')
                {
                    icv_string += String.valueOf(lex);
                    lex = input.charAt(++index);
                }

                icv_string += String.valueOf(lex);
                index++;

                html_string += "<p style='color:green'>" + icv_string + "</p> ";
                icv_string += " ";
                html_string_2 += "<font color='green' size='3'>" + icv_string + "</font>";

                //System.out.println("strings : " + icv_string);
                code = 100;
                continue;
                //return code;
            }

            if (lex==39)
            {
                icv_string = String.valueOf(lex);

                lex = input.charAt(++index);

                while (lex!=39)                         // 39 is ASCII number for apostrophe
                {
                    icv_string += String.valueOf(lex);
                    lex=input.charAt(++index);
                }

                icv_string += String.valueOf(lex);

                html_string_2 += "<font color='green' size='3'>"+icv_string+"</font>";
                index++;
                code = 101;
                continue;

                //return code;
            }


            if(lex==92)                         // 92 is ASCII code for backslash (\)
            {
                icv_string=String.valueOf(lex);
                lex=input.charAt(++index);

                html_string_2+="<font  color='green' size='3'>"+icv_string+"</font>";
                index++;
                continue;
            }

            //******************************************************************
            if (code_of_operators_for_parser_2.contains(String.valueOf(lex)) && (index <= input.length() - 3) && !(lex == '/' && input.charAt(index + 1) == '/') && !(lex == '/' && input.charAt(index + 1) == '*')    )
            {
                icv_string = String.valueOf(lex);

                lex = input.charAt(++index);

                if (code_of_operators_for_parser_2.contains(String.valueOf(lex)) || lex == '=') {
                    icv_string += String.valueOf(lex);
                    html_string += "<p style='color:black'>" + icv_string + "</p> ";
                    icv_string += " ";
                    float tmpf;
                    html_string_2 += "<font color='black' size='3'>" + icv_string + " </font>";
                    lex=input.charAt(++index);
                    if(lex==' ' && input.charAt(index-1)=='=')

                        code = code_of_operators_for_parser_2.indexOf(icv_string);
                    continue;
                    //return code;
                }

                html_string += "<p style='color:black'>" + icv_string + "</p> ";
                icv_string += " ";
                html_string_2 += "<font color='black' size='3'>" + icv_string + " </font>";

                code = code_of_operators_for_parser_2.indexOf(icv_string);
                //System.out.println("here some operator shit : "+icv_string);
                continue;
                //return code;
            }


            if (lex==' ')
            {
                while (lex==' ' && index<=input.length()-2)
                {
                    lex = input.charAt(++index);
                }
            }

            char myE='E';
            String scientific = null;

            if (lex >='0' && lex<='9') {
                icv = (int) lex - (int) flag;

                if(index<=input.length()-2)
                    lex = input.charAt(++index);

                if (lex == '.')
                {
                    lex = input.charAt(++index);

                    while (lex >= '1' && lex <= '9' && index<=input.length()-2)
                    {
                        icv_after_point = icv_after_point + help * ((int) lex - (int) flag);
                        help = help / 10;
                        lex = input.charAt(++index);
                    }
                    if (lex == 'E')
                    {
                        scientific=String.valueOf('E');

                        lex=input.charAt(++index);
                        if(lex==' ')
                        {
                            scientific+=String.valueOf(' ');
                        }
                        else if(lex=='-' || lex=='+')
                        {
                            scientific+=String.valueOf(lex);
                            lex=input.charAt(++index);

                            while (lex>='0' && lex<='9')
                            {
                                scientific+=String.valueOf(lex);
                                lex=input.charAt(++index);
                            }
                        }
                    }
                    icv = icv + icv_after_point;

                    html_string += "<p style='color:brown'>  <i>" + icv+scientific+"</i> </p>";  // italic and orange for real numbers...
                    html_string_2 += "<font color='orange' size='3'>  <i>"+icv +scientific+"</i>"+" </font>";

                    code = 55;
                    continue;
                    //return code;
                }

                while (lex == '0' || lex == '1' || lex == '2' || lex == '3' || lex == '4' || lex == '5' || lex == '6' || lex == '7' || lex == '8' || lex == '9') {

                    icv = (10 * icv) + (int) lex - (int) flag;
                    if(index<=input.length()-2)
                        lex = input.charAt(++index);
                    else return  33;
                }

                if (lex != '.')
                {
                    html_string += "<p style='color:orange'>" + (int) icv + "</p> ";

                    html_string_2 += "<font color='orange' size='3'>" + (int) icv + " " + " </font>";
                    code = 50;//integer number
                    continue;
                }
                if (lex == '.')
                {

                    lex = input.charAt(++index);

                    while (lex >= '0' && lex <= '9' && index<=input.length()-1)
                    {
                        icv_after_point = icv_after_point + help * ((int) lex - (int) flag);
                        help = help / 10;
                        lex = input.charAt(++index);
                    }

                    icv = icv + icv_after_point;
                    html_string += "<p style='color:orange'>  <i>" + icv + "</i> </p>";      // italic and orange for real numbers...
                    html_string_2 += "<font color='orange' size='3'> <i>" + icv + "</i> " + "</font>";
                    code = 55;
                    continue;
                    //return code;
                }
            }

            //******************************************************

            if ((lex >= 'a' && lex <= 'z') || (lex >= 'A' && lex <= 'Z'))
            {
                icv_string = String.valueOf(lex);
                lex = input.charAt(++index);

                while ((lex >= 'a' && lex <= 'z') || (lex >= 'A' && lex <= 'Z') || (lex >= '0' && lex <= '9') || (lex == '_') && (index <= input.length() - 1))
                {
                    icv_string += String.valueOf(lex);

                    if (index + 1 <= input.length() - 1)
                        lex = input.charAt(++index);
                }

                if (kwt.contains(icv_string) && lex==' ')
                {

                    icv_string += " ";
                    int s;
                    html_string_2 += "<font color='blue' size='3'> <b>" + icv_string +"</b>" +"</font>";

                    int s2;
                    code = 51;

                    index++;

                    continue;
                    //return code;
                }


                //icv_string+=String.valueOf(lex);


                if ( (lex==';')  &&( (lex == ' ' && input.charAt(index - 1) == '_')  ||  (  !(lex>='a' && lex<='z') &&  !(lex>='A' && lex<='Z' )  &&  (lex!='_')  ) ) && !(kwt.contains(icv_string))|| (lex>=91 && lex<=96) &&!(code_of_operators_for_parser_2.contains(lex)) )
                {
                    icv_string+=String.valueOf(lex);

                    if(lex==' ' && input.charAt(index-1)!='_')
                    {
                        continue;
                    }

                    while (lex!=' ' && index<input.length()-2 && lex!=';')
                    {
                    /*   if(code_of_operators_for_parser_2.contains(String.valueOf(lex)))
                        {
                            html_string_2+="<font color='red' size='3'>"+icv_string+"</font>";
                            html_string_2 += "<font color='black' size='3'>"+lex+"</font>";
                            System.out.println("kirr"+html_string_2);
                            lex=input.charAt(++index);
                            System.out.println("iniffffkk"+lex);

                        }  */

                        //icv_string+=String.valueOf(lex);
                        lex=input.charAt(++index);
                        icv_string+=String.valueOf(lex);

                    }

                    System.out.println("ID can not have underline for last char....ERROR");
                    html_string_2+="<font color='red' size='3'>"+icv_string+"</font>";
                    index++;
                    //return -3;
                    continue;
                }


                if (lex == ' ' || code_of_operators_for_parser_2.contains(String.valueOf(input.charAt(index))))
                {
                    if (kwt.contains(icv_string))
                    {
                        html_string += "<p style='color:blue'>  <b>" + icv_string + "</b> </p>";
                        //icv_string += " ";
                        html_string_2 += "<font color='blue' face='Bold' size='3'>" + icv_string + "</font>";

                        code = 51;
                        continue;
                        //return code;
                    }


                    if (!kwt.contains(icv_string))
                    {

                        if(lex==' ')
                        {
                            icv_string += " ";
                            html_string_2 += "<font color='Violate' size='3'>" + icv_string + "</font>";
                        }
                        else if(code_of_operators_for_parser_2.contains(String.valueOf(lex)))
                        {
                            html_string_2+="<font color='violate' size='3'>"+icv_string+"</font>";
                            continue;
                        }

                        code = 52;
                        continue;
                        //return code;
                    }
                }
                if (lex != ' ')
                {
                    icv_string += String.valueOf(lex);

                    if(index<=input.length()-2)
                        lex = input.charAt(++index);

                    while (lex != ' ' && index <= input.length() - 2   &&  !(lex=='/' && input.charAt(index+1)=='/'))
                    {

                        icv_string += String.valueOf(lex);
                        lex = input.charAt(++index);
                    }

                    html_string += "<p style='color:red'>" + icv_string + "</p> ";// icv is the red_string itself here...
                    //icv_string += " ";
                    html_string_2 += "<font color='red' size='3'>" + icv_string + " </font>";

                    code = -2;
                    //return code;
                }

                code = 51;  // 51 is a code for identifiers or key words....
                continue;
                //return code;
            }
            //******************************************************
            else if (lex == ' ' && index<=input.length()-2)
            {
                lex = input.charAt(++index);
                while (lex == ' ' && index <= input.length() - 2)
                {
                    lex = input.charAt(++index);
                }
                continue;
                // return -1;
            }
            //****************************************************

            if(index==';')
                continue;

            if (lex == '/' && input.charAt(index + 1) == '*')
            {
                string_comment += String.valueOf(lex);

                lex = input.charAt(++index);
                if (lex == '*')
                {

                    string_comment += String.valueOf(lex);
                    lex = input.charAt(++index);

                    while (lex != '*')
                    {

                        string_comment += String.valueOf(lex);
                        lex = input.charAt(++index);
                    }

                    string_comment += String.valueOf(lex);
                    lex = input.charAt(++index);

                    string_comment += String.valueOf(lex);
                }
                html_string += "<p style='color:yellow'>" + string_comment + "</p> ";
                string_comment += " ";
                html_string_2 += "<font color='yellow' size='3'>" + string_comment + "</font>";
                index++;

                code = 70;
                continue;
                //return code;
            }

            if (lex == '/' && input.charAt(index+1)=='/')
            {
                string_comment = String.valueOf(lex);
                int alaki;
                lex = input.charAt(++index);


                string_comment += String.valueOf(lex);
                lex = input.charAt(++index);

                while (index <= input.length() - 2)
                {
                    string_comment += String.valueOf(lex);
                    lex = input.charAt(++index);
                }

                string_comment += String.valueOf(lex);

                html_string_2 += "<font color='yellow' size='3'>" + string_comment + "</font>";
                code = 70;
                continue;
                //return code;
            }

            //******************************************************

            if((  (lex >= 'a' && lex <= 'z') ||  (lex>='A' && lex<='Z') || (lex>='0' && lex<=9) ) ) {
                red_string = String.valueOf(lex);
                lex = input.charAt(++index);

                if ((!(lex >= 'a' && lex <= 'z') && !(lex >= 'A' && lex <= 'Z') && !(lex >= '0' && lex <= 9) && !(lex == '_')))
                {

                    red_string += String.valueOf(lex);

                    while ((lex != ' ') && (index <= input.length() - 2) ) {

                        if(lex==';')
                            break;

                        lex = input.charAt(++index);
                        red_string += String.valueOf(lex);

                    }
                    html_string_2+="<font color='red' size='3' "+red_string+"</font>";
                }
            }
           /* else if (lex != ' ' && !kwt.contains(lex) && !code_of_operators_for_parser_2.contains(lex) && lex != '=') {

                red_string = String.valueOf(lex);
                lex = input.charAt(++index);

           while (lex != ' '  && index<=input.length()-4)
            {
                System.out.println("index:"+index);
                red_string += String.valueOf(lex);
                lex = input.charAt(++index);
            }

            System.out.println("Unknown strings : " + red_string);
            html_string += "<p style='color:red'>" + red_string + "</p> ";
            red_string+=" ";
            html_string_2+="<font color='red' size='3'>"+red_string +"</font>";
            System.out.println("html2:"+html_string_2);

            code = -2;
            //return code;
        }}
   */

        }
        html_string_2+=" </body> </html>";
        return 33;
    }



    public static void getLines()
    {
        String output_lex=null;
        try
        {
            FileReader fileReader = new FileReader(input_file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer=new StringBuffer();

            output_lex=bufferedReader.readLine();
            all_the_lines.add(output_lex);

            while (output_lex!=null)
            {

                output_lex= bufferedReader.readLine();
                all_the_lines.add(output_lex);
            }

        }catch (Exception e)
        {

            e.printStackTrace();
        }
        counter_for_getLines++;
    }


    public static void main(String[] args)
    {

        try {
            boolean result=false;
            if(!input_file.exists())
            {
                //result = input_file.createNewFile();
            }
            if(result)
                System.out.println("The file created.");
            else
                System.out.println("File did not created.");


            set_operators_code();
            set_kwt();

            getLines();

        /*    System.out.println(all_the_lines);
            all_the_lines.remove(0);
            System.out.println(all_the_lines);
            all_the_lines.remove(0);
            System.out.println(all_the_lines);      */


            while (all_the_lines.size()>1)
            {

                scan_char_by_char();
                all_the_lines.remove(0);
                html_string_2+="</br>";

            }

           /* all_the_lines.remove(0);
            all_the_lines.remove(0);
            all_the_lines.remove(0);
            all_the_lines.remove(0);

            scan_char_by_char();

**/
            create_html_file();

        }catch (Exception e)
        {
            System.out.println("Some thing went wrong during creating input file...!");
            e.printStackTrace();
        }
    }
}

