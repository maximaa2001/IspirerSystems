import i18n from "./i18n";
import {useTranslation} from "react-i18next";
import CustomButton from "./Component/Button/CustomButton";
import 'bootstrap/dist/css/bootstrap.min.css';
import style from "./App.module.css"
import CustomComboBox from "./Component/ComboBox/CustomComboBox";
import Constant from "./Constant/Constant";
import Modal from "./Component/Modal/Modal";
import { useState } from "react";



function App() {
  const { t } = useTranslation();
  const [visible, setVisible] = useState(false);

  return (
    <div>
    <div>
      <div className={style.mainText}>{t('main')}</div>
    </div>
    <div className={style.buttonAndComboBox}>
    <CustomButton style={{width: "200px"}} onClick={() => setVisible(true)}>{t("showWindow")}</CustomButton>
    <CustomComboBox style={{width: "200px", marginLeft: "20px"}} onChange={event => i18n.changeLanguage(event.target.value)} elements={Constant.languages}/>
    <Modal visible={visible} setVisible={() => setVisible(false)}>{t('popUpWindow')}</Modal>
    </div>
   
    </div>
  );
}

export default App;
