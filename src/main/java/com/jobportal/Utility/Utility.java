package com.jobportal.Utility;

import org.springframework.stereotype.Component;

@Component
public class Utility {
    public static String generateOTP(){
        StringBuilder otp = new StringBuilder();
        for(int i=1; i<=6; i++){
            otp.append((char)(Math.random()*9+'0'));
        }
        return otp.toString();
    }

    public static String HtmlTemplate(String otp){
        String tmp = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>OTP Email</title>
            </head>
            <body style="background-color: #f3f4f6; font-family: Arial, sans-serif; margin: 0; padding: 0;">
                <div style="max-width: 600px; margin: 20px auto; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);">
                    <!-- Header -->
                    <div style="text-align: center;">
                        <h1 style="font-size: 24px; color: #1f2937; margin-bottom: 8px;">Your OTP Code</h1>
                        <p style="color: #6b7280; font-size: 16px; margin: 0;">Please use the code below to complete your action.</p>
                    </div>
                    
                    <!-- OTP Section -->
                    <div style="text-align: center; margin-top: 20px;">
                        <p style="font-size: 18px; color: #4b5563; font-weight: bold;">Your OTP Code:</p>
                        <div style="margin: 10px 0;">
                            <span style="font-size: 36px; font-weight: bold; color: #6366f1;">{{OTP}}</span>
                        </div>
                        <p style="color: #9ca3af; font-size: 14px;">This code is valid for 10 minutes.</p>
                    </div>
                    
                    <!-- Instructions -->
                    <div style="margin-top: 20px; color: #4b5563; font-size: 14px;">
                        <p>Didn't request an OTP? Please ignore this email or contact our support team if you have any concerns.</p>
                    </div>
                    
                    <!-- Button -->
                    <div style="text-align: center; margin-top: 20px;">
                        <a href="http://localhost:5173/" style="display: inline-block; padding: 12px 24px; color: #ffffff; background-color: #6366f1; text-decoration: none; border-radius: 6px; font-size: 14px; font-weight: bold;">Go to Website</a>
                    </div> 
                    
                    <!-- Footer -->
                    <div style="margin-top: 30px; text-align: center; color: #9ca3af; font-size: 12px;">
                        <p>© 2025 Omair Saad. All rights reserved.</p>
                        <p>1234 Street Address, Mau, State, Zip</p>
                    </div>
                </div>
            </body>
            </html>
            """;

        // Replace the placeholder {{OTP}} with the actual OTP value
        tmp = tmp.replace("{{OTP}}", otp);

        return tmp;
    }
}
