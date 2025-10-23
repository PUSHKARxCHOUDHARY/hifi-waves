// frontend/script.js — Live Server version (explicit backend URL)
console.log('frontend script loaded (Live Server)');

const BACKEND_URL = 'http://localhost:3000'; // change if your backend uses another port
const socket = io(BACKEND_URL, { transports: ['websocket', 'polling'] });

console.log('attempting socket connect to', BACKEND_URL);

// DOM
const loginScreen = document.getElementById('login-screen');
const usernameInput = document.getElementById('username-input');
const loginBtn = document.getElementById('login-btn');
const loginDebug = document.getElementById('login-debug');

const chatContainer = document.getElementById('chat-container');
const usernameDisplay = document.getElementById('username-display');
const messagesEl = document.getElementById('messages');
const chatForm = document.getElementById('chat-form');
const messageInput = document.getElementById('message-input');

let username = '';
let color = '#4e73df';

// escape helper
function escapeHtml(str){ return String(str).replace(/[&<>"']/g, (m)=> ({'&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;',"'":'&#39;'}[m])); }

// debug socket events
socket.on('connect', () => console.log('socket connected', socket.id));
socket.on('connect_error', (err) => console.error('connect_error', err));
socket.on('disconnect', (r) => console.log('socket disconnected', r));

// join
loginBtn.addEventListener('click', () => {
  console.log('login clicked');
  const name = usernameInput.value.trim();
  if (!name) { loginDebug.textContent = 'Please enter a username'; return; }
  username = name;
  color = ['#FF5733','#33FF57','#3357FF','#F333FF','#33FFF0','#FF33EC'][Math.floor(Math.random()*6)];
  usernameDisplay.textContent = `Logged in as: ${username}`;
  loginScreen.classList.add('hidden');
  chatContainer.classList.remove('hidden');
  socket.emit('join', { username });
});

// send message
chatForm.addEventListener('submit', (e) => {
  e.preventDefault();
  const msg = messageInput.value.trim();
  if (!msg) return;
  const payload = { username, message: msg, color, timestamp: new Date().toLocaleTimeString([], {hour:'2-digit', minute:'2-digit'}) };
  socket.emit('chat message', payload);
  messageInput.value = '';
  messageInput.focus();
});

// receive
socket.on('chat message', (data) => {
  addMessage(data);
});

// render
function addMessage(data){
  const div = document.createElement('div');
  div.className = 'message ' + (data.username === username ? 'sent' : 'received');
  if (data.username === username) div.style.backgroundColor = data.color || '#4e73df';

  const content = document.createElement('div');
  content.innerHTML = `<strong>${escapeHtml(data.username === username ? 'You' : data.username)}</strong><div>${escapeHtml(data.message)}</div>`;

  const meta = document.createElement('div');
  meta.className = 'meta';
  meta.textContent = data.timestamp || '';

  div.appendChild(content);
  div.appendChild(meta);
  messagesEl.appendChild(div);
  messagesEl.scrollTop = messagesEl.scrollHeight;
}
