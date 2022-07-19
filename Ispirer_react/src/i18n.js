import i18n from "i18next";
import { initReactI18next } from "react-i18next";

const localeEN = {
    main: "this simple web application is a test project for a company",
    showWindow: "show window",
    popUpWindow: "popup window with text in selected language"
  };
  
  const localeRU = {
    main: "это простое веб приложение является тестовым заданием для компании",
    showWindow: "показать окно",
    popUpWindow: "всплывающее окно с текстом на выбранном языке"
  };


i18n
.use(initReactI18next) 
.init({
  resources: {
    en: { translation: localeEN },
    ru: { translation: localeRU },
  },
  lng: "en",
  fallbackLng: "en",
  interpolation: { escapeValue: false },
});

export default i18n;