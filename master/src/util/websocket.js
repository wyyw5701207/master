export default class WebSocketClient {
  constructor(url) {
    this.url = url;
    this.socket = null;
    this.onOpenCallback = null; // 连接建立时的回调函数
    this.onMessageCallback = null; // 接收到消息时的回调函数
    this.onCloseCallback = null; // 连接关闭时的回调函数
    this.onErrorCallback = null; // 连接发生错误时的回调函数
  }

  connect() {
    this.socket = new WebSocket(this.url);
    this.socket.onopen = event => { // WebSocket 连接建立时触发
      if (this.onOpenCallback) {
        this.onOpenCallback(event);
      }
    };
    this.socket.onmessage = event => { // 收到服务器发送的消息时触发
      if (this.onMessageCallback) {
        this.onMessageCallback(event.data); // 将消息数据作为参数传递给回调函数
      }
    };
    this.socket.onclose = event => { // WebSocket 连接关闭时触发
      if (this.onCloseCallback) {
        this.onCloseCallback(event);
      }
    };
    this.socket.onerror = error => { // WebSocket 连接出错时触发
      if (this.onErrorCallback) {
        this.onErrorCallback(error);
      }
    };
  }

  send(message) {
    if (this.socket && this.socket.readyState === WebSocket.OPEN) { // 确保连接已经建立并且状态为打开
      this.socket.send(message); // 发送消息
    }
  }

  close() {
    if (this.socket) {
      this.socket.close(); // 关闭 WebSocket 连接
    }
  }

  onOpen(callback) {
    this.onOpenCallback = callback; // 设置连接建立时的回调函数
  }

  onMessage(callback) {
    this.onMessageCallback = callback; // 设置接收到消息时的回调函数
  }

  onClose(callback) {
    this.onCloseCallback = callback; // 设置连接关闭时的回调函数
  }

  onError(callback) {
    this.onErrorCallback = callback; // 设置连接发生错误时的回调函数
  }
}