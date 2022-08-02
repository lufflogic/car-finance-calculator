/*
MIT License

Copyright (c) 2022 Chris Luff

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.fluffyluffs.car.finance.calculator.controller.impl;

/** Calculator */
public class Calculator {

  private final double interestRate;
  private final double principal;
  private final int termInMonths;
  private final double deposit;
  private final double residual;

  /**
   * Calculate a car payment
   *
   * @param interestRate interest rate in the form of a decimal, i.e. 5.3
   * @param principal total repayable after any deposit
   * @param termInMonths duration of loan
   * @param deposit amount to be deducted from loan
   * @param residual
   */
  public Calculator(
      double interestRate, double principal, int termInMonths, double deposit, double residual) {

    this.interestRate = interestRate;
    this.principal = principal;
    this.termInMonths = termInMonths;
    this.deposit = deposit;
    this.residual = residual;
  }

  public int getMonthly() {
    double rate = interestRate == 0.0 ? 0.0000001 : interestRate;
    
    double s = principal - deposit;
    double b = residual;
    double r = Math.pow((1 + rate / 100), (1d / 12)) - 1;
    int n = termInMonths;

    return (int)Math.round((r * (Math.pow((1 + r), n) * s - b)) / (Math.pow((1 + r), n) - 1));
  }
}
