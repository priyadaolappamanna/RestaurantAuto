package com.Restaurant.Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.BaseClass;

public class HomePage extends BaseClass{
public HomePage()
{
	PageFactory.initElements(getDriver(), this);
	}
//Language 
@FindBy(xpath="(//span[@class='caret'])[3]")
WebElement Language;
//english language
	@FindBy(xpath="//a[text()=' English']")
	WebElement English;
	//Heading of english
	@FindBy(xpath="//h1[contains(text(),' Choose a store ')]")
	WebElement Engheading;
	//French
	@FindBy(xpath="//a[text()=' Français']")
	WebElement French;
	//heading f french
	@FindBy(xpath="//h1[contains(text(),' Choisissez un boutique ')]")
	WebElement FrenchHead;
	//portugese
	@FindBy(xpath="//a[text()=' Portuguese']")
	WebElement Portugese;
	//heading of portugese
	@FindBy(xpath="//h1[contains(text(),' Escolha uma loja ')]")
	WebElement PortugeseHead;
	public WebElement language()
	{
		return Language;
		
	}
	public WebElement Eng()
	{
		return English;
	}
	public WebElement EngHead()
	{
		return Engheading;
	}
	public WebElement France()
	{
		return French;
	}
	public WebElement FrenchHeading()
	{
		return FrenchHead;
	}
	public WebElement Portugesee()
	{
		return Portugese;
		
	}
public WebElement PortugalHead()
{
	return PortugeseHead;
	}

public void ClickOnEnglishLanguage()
{
	action.click1(Language, "clicking on language dropdown");
	action.explicitWait(getDriver(), English, Duration.ofSeconds(20));
	action.click1(English, "clicking on English language ");
}
public void ClickOnFrenchLanguage()
{
	action.click1(Language, "clicking on language dropdown");
	action.explicitWait(getDriver(), French, Duration.ofSeconds(20));
	action.click1(French, "clicking on French language ");
}
public void ClickOnPortugalLanguage()
{
	action.click1(Language, "clicking on language dropdown");
	action.explicitWait(getDriver(), Portugese, Duration.ofSeconds(20));
	action.click1(Portugese, "clicking on Portugese language ");
}
public boolean IsFrenchLanguagePresent()
{
return action.isDisplayed(getDriver(), FrenchHead);	
}
public boolean IsPortugeseLanguagePresent()
{
	return action.isDisplayed(getDriver(), PortugeseHead);
	}
public boolean IsEnglishLanguagePresent()
{
	return action.isDisplayed(getDriver(), Engheading);
}
}


