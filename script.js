const btnTaxManager = document.querySelector('.btnz1');
const btnBillManager = document.querySelector('.btnz2');
const taxManagerContent = document.querySelector('.content1');
const billManagerContent = document.querySelector('.content2');
const btnNew = document.querySelector('.btn-add-new');
const btnAdd = document.querySelector('.btn-add-add');
const addDisp = document.querySelector('.add-display');

const taxManager = () => {
  btnTaxManager.classList.add('active');
  btnTaxManager.classList.remove('inactive');
  taxManagerContent.classList.add('active');

  btnBillManager.classList.remove('active');
  btnBillManager.classList.add('inactive');
  billManagerContent.classList.remove('active');
};

const billManager = () => {
  btnBillManager.classList.add('active');
  btnBillManager.classList.remove('inactive');
  billManagerContent.classList.add('active');

  btnTaxManager.classList.remove('active');
  btnTaxManager.classList.add('inactive');
  taxManagerContent.classList.remove('active');
};

const addBill = () => {
  addDisp.classList.add('hidden');
  btnNew.classList.remove('hidden');
};
const newBill = () => {
  btnNew.classList.add('hidden');
  addDisp.classList.remove('hidden');
};

btnTaxManager.addEventListener('click', taxManager);
btnBillManager.addEventListener('click', billManager);
btnAdd.addEventListener('click', addBill);
btnNew.addEventListener('click', newBill);
