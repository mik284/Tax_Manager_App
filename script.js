const btnTaxManager = document.querySelector('.btnz1');
const btnBillManager = document.querySelector('.btnz2');
const taxManagerContent = document.querySelector('.content1');
const billManagerContent = document.querySelector('.content2');
const btnNew = document.querySelector('.btn-add-new');
const btnAdd = document.querySelector('.btn-add-add');
const addDisp = document.querySelector('.add-display');

const grossSalary = document.querySelector('#gross');
const nssfContribution = document.querySelector('#nssf');
const nhifContribution = document.querySelector('#nhif');
const taxableIncome = document.querySelector('#taxable');
const beforeRelief = document.querySelector('#tax-br');
const reliefInput = document.querySelector('#relief');
const payeInput = document.querySelector('#paye');
const netSalary = document.querySelector('#net');
const calculateTax = document.querySelector('.calculate1');

const netPay = document.querySelector('.net2');
const billsEls = document.querySelectorAll('.bill');
const balancePlate = document.querySelector('.balance-plate');
const balanceEl = document.querySelector('.bal');
const calculateBill = document.querySelector('.calculate2');

const billCategories = document.querySelector('.bill-cats')
const newCategory = document.querySelector('.new-category')

const grossTax = () => {
  let gross = Number(grossSalary.value);

  let nssf = gross * 0.06;
  let nhif = 300;
  let paye = gross * 0.1;
  let relief = paye * 0.15;
  let netPay = gross - nhif - nssf - (paye - relief);

  beforeRelief.value = paye;
  taxableIncome.value = gross;
  nhifContribution.value = nhif;
  nssfContribution.value = nssf;
  payeInput.value = paye;
  reliefInput.value = relief;
  netSalary.value = netPay;
  console.log(gross);
};

const bill = () => {
  let available = Number(netPay.value);
  let bills = [...billsEls].map(it => Number(it.value));
  let balance = available;
  
  let totalBill = bills.reduce((acc, el) =>  (acc + el), 0);
  console.log(totalBill)

  if (totalBill > available) {
    console.log('Total bill exceeds net pay')
  } else {
    balance = available - totalBill;
  }

  balancePlate.classList.remove('hidden');
  balanceEl.textContent = balance;
};

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
  let newCat = newCategory.value;

  addDisp.classList.add('hidden');
  btnNew.classList.remove('hidden');
  
  if (newCat) {
    let html = `
      <article class="item">
        <p>
          <label>${newCat}:</label>
          <input
            class="ksh bill"
            name="newCat"
            type="number"
            placeholder="Ksh." />
        </p>
      </article>
    `

    console.log(billCategories.innerHTML)
    billCategories.insertAdjacentHTML('beforeend', html);
    newCategory.value = ''
  } else {
    console.log("Category is null")
  }


};

const newBill = () => {
  btnNew.classList.add('hidden');
  addDisp.classList.remove('hidden');
};

btnTaxManager.addEventListener('click', taxManager);
btnBillManager.addEventListener('click', billManager);
btnAdd.addEventListener('click', addBill);
btnNew.addEventListener('click', newBill);

calculateTax.addEventListener('click', grossTax);
calculateBill.addEventListener('click', bill);
