/**
* @Author: 刘健明
* @param:公共JS文件
* @Date: Created in 10:20 2018/1/11
*/
function changeVerifyCode(img) {
    img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}